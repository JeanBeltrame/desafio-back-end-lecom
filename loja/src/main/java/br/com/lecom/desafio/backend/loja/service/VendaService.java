package br.com.lecom.desafio.backend.loja.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lecom.desafio.backend.loja.client.CatalogoClient;
import br.com.lecom.desafio.backend.loja.client.TransportadoraClient;
import br.com.lecom.desafio.backend.loja.dto.EntregaComVendaDTO;
import br.com.lecom.desafio.backend.loja.dto.EntregaDTO;
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
	
	@Autowired
	private ProdutoService produtoService;
	
	public List<VendaDTO> todasVendas() {
		List<Venda> vendas = vendaRepository.findAllByOrderByIdDesc();
		
		List<VendaDTO> vendaDTO = vendas
				.stream()
				.map(venda -> toVendaDTO(venda))
				.collect(Collectors.toList());
		
		return vendaDTO;
	}
	
	

	public EntregaDTO realizaCompra(VendaDTO vendaDTO) {
		
		if(vendaDTO == null) {
			return null;
		}
		
		vendaDTO.setPrecoTotal(calculaPrecoTotal(vendaDTO.getItens()));
		
		Venda venda = toVenda(vendaDTO);
		
		vendaDTO.setVendaId(vendaRepository.save(venda).getId());
		
		return transportadoraClient.realizaCompra(vendaDTO);
	}
	
	
	

	public List<EntregaComVendaDTO> todasEntregas() {
		List<EntregaComVendaDTO> entregaComVenda = transportadoraClient.todasEntregas()
				.stream()
				.map(entrega -> {
					System.out.println(entrega.getVendaId());
					return toEntregaComVendaDTO(entrega);
				})
				.collect(Collectors.toList());
				
		return entregaComVenda;
	}
	
	
	
	private BigDecimal calculaPrecoTotal(List<VendaItemDTO> itens) {
		BigDecimal precoAux = new BigDecimal(0);
		List<BigDecimal> listaDePrecos =  itens
				.stream()
				.map(item -> {
					BigDecimal precoTotal = new BigDecimal(0);
					BigDecimal quantidade = new BigDecimal( item.getQuantidade() );
					BigDecimal precoProduto = produtoService.buscarProdutoPorId(item.getProduto().getId()).getBody().getPrecoUnitario();
					BigDecimal precoItem = quantidade.multiply(precoProduto);
					
					precoTotal = precoTotal.add(precoItem);
					return precoTotal;
				}).collect(Collectors.toList());
		
		precoAux = listaDePrecos.
				stream()
				.reduce(precoAux, (subtotal, element) -> subtotal.add(element));
		
		return precoAux;
	}
	
	
	
	// ---------------- métodos de conversão ------------------------- //
	
	
	
	private EntregaComVendaDTO toEntregaComVendaDTO(EntregaDTO entrega) {
		Venda venda = vendaRepository.findById( entrega.getVendaId() ).get();
		VendaDTO vendaDTO = toVendaDTO(venda);
		EntregaComVendaDTO entregaEVenda = new EntregaComVendaDTO();
		
		entregaEVenda.setNomeProduto(vendaDTO.getItens()
				.stream().
				map(
					item -> item.getProduto().getNome()
				).collect(Collectors.toList()));
		
		entregaEVenda.setStatus(entrega.getStatus());
		entregaEVenda.setCepRemetente(entrega.getCepRemetente());
		entregaEVenda.setCepDestinatario(entrega.getCepDestinatario());
		
		return entregaEVenda;
	}
	
	
	private VendaDTO toVendaDTO(Venda venda) {
		List<VendaItem> itens =  venda.getItens();
		List<VendaItemDTO> itensDTO = itens
				.stream()
				.map(item -> toItemDTO(item))
				.collect(Collectors.toList());
		
		VendaDTO vendaDTO = new VendaDTO();
		vendaDTO.setVendaId(venda.getId());
		vendaDTO.setCepDestinatario(venda.getCepDestinatario());
		vendaDTO.setItens(itensDTO);
		vendaDTO.setPrecoTotal(venda.getPrecoTotal());
		
		return vendaDTO;
	}
	

	private VendaItemDTO toItemDTO(VendaItem vendaItem) {
		VendaItemDTO vendaItemDTO = new VendaItemDTO();
		
		vendaItemDTO.setId(vendaItem.getId());
		vendaItemDTO.setQuantidade(vendaItem.getQuantidade());
		vendaItemDTO.setVendaId(vendaItem.getVendaId());

		ResponseEntity<ProdutoDTO> produtoPorId = catalogoClient.getProdutoPorId( vendaItem.getProdutoId() );
		
		vendaItemDTO.setProduto(produtoPorId.getBody());
		
		return vendaItemDTO;
	}
	
	
	private VendaItem toItem(VendaItemDTO vendaItemDTO) {
		
		VendaItem vendaItem = new VendaItem(
				vendaItemDTO.getId(),
				vendaItemDTO.getVendaId(),
				vendaItemDTO.getProduto().getId(),
				vendaItemDTO.getQuantidade()
			);
		
		return vendaItem;
	}
	
	
	private Venda toVenda(VendaDTO vendaDTO) {
		
		List<VendaItem> vendaItens = vendaDTO.getItens()
				.stream()
				.map(itemDTO -> toItem(itemDTO))
				.collect(Collectors.toList());
		
		Venda venda = new Venda(
					vendaDTO.getVendaId(),
					vendaItens,
					vendaDTO.getCepDestinatario(),
					vendaDTO.getPrecoTotal()
				);
		
		return venda;
	}
	
}
