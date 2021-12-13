package br.com.lecom.desafio.backend.loja.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lecom.desafio.backend.loja.client.CatalogoClient;
import br.com.lecom.desafio.backend.loja.client.TransportadoraClient;
import br.com.lecom.desafio.backend.loja.dto.ProdutoDTO;
import br.com.lecom.desafio.backend.loja.dto.VendaDTO;
import br.com.lecom.desafio.backend.loja.dto.VendaItemDTO;
import br.com.lecom.desafio.backend.loja.model.Venda;
import br.com.lecom.desafio.backend.loja.model.VendaItem;
import br.com.lecom.desafio.backend.loja.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private TransportadoraClient transportadoraClient;
	
	@Autowired
	private CatalogoClient catalogoClient;
	
	public List<VendaDTO> todasVendas() {
		List<Venda> vendas = vendaRepository.findAll();
		
		List<VendaDTO> vendaDTO = vendas
				.stream()
				.map(venda -> toVendaDTO(venda))
				.collect(Collectors.toList());
		
		return vendaDTO;
	}

	public Venda realizaCompra(Venda venda) {
		if(venda == null) {
			return null;
		}
		
		VendaDTO vendaDTO = new VendaDTO(venda);
		
		transportadoraClient.realizaCompra(vendaDTO);
		
		venda.setStatus(null);
		vendaRepository.save(venda);
		
		return venda;
	}
	
	private VendaDTO toVendaDTO(Venda venda) {
		List<VendaItem> itens =  venda.getItens();
		List<VendaItemDTO> itensDTO = itens
				.stream()
				.map(item -> toItemDTO(item))
				.collect(Collectors.toList());
		
		VendaDTO vendaDTO = new VendaDTO();
		vendaDTO.setvendaId(venda.getId());
		vendaDTO.setItens(itensDTO);
		vendaDTO.setCepDestinatario(venda.getDestino());
		

		
//		List<Long> idsProdutos = itens
//				.stream()
//				.map(item -> {
//					itensDTO.add(toItemDTO(item));
//					return item.getId();
//				})
//				.collect(Collectors.toList());
//		
//		List<ProdutoDTO> produtos = catalogoClient.getVariosProdutosPorId(idsProdutos);
		
//		List<VendaItemDTO> itensDTO = produtos
//				.stream()
//				.map(produtoDTO -> {
//				
//				});
//		
//		
//		itensDTO.stream()
//			.map(itemDTO -> itemDTO.setProduto())
//		
		return vendaDTO;
	}

	private VendaItemDTO toItemDTO(VendaItem vendaItem) {
		VendaItemDTO vendaItemDTO = new VendaItemDTO();
		
		vendaItemDTO.setQuantidade(vendaItem.getQuantidade());

		ResponseEntity<ProdutoDTO> produtoPorId = catalogoClient.getProdutoPorId( vendaItem.getProdutoId() );
		
		vendaItemDTO.setProduto(produtoPorId.getBody());
		
		return vendaItemDTO;
	}
	
}
