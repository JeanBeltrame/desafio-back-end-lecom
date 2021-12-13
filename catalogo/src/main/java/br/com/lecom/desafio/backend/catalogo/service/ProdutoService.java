package br.com.lecom.desafio.backend.catalogo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lecom.desafio.backend.catalogo.dto.ProdutoDTO;
import br.com.lecom.desafio.backend.catalogo.model.Produto;
import br.com.lecom.desafio.backend.catalogo.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getTodosProdutos() {
		return produtoRepository.findAll();
	}

	public ResponseEntity<Produto> getProdutoPorId(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if(produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}

	public List<ProdutoDTO> getVariosProdutosPorId(List<Long> ids) {
		
		List<Produto> produtos = produtoRepository.findByIdIn(ids);
		
		List<ProdutoDTO> produtosDTO = produtos
				.stream()
				.map(produto -> toProdutoDTO(produto))
				.collect(Collectors.toList());
		
		return produtosDTO;
	}
	
	private ProdutoDTO toProdutoDTO(Produto produto) {
		
		ProdutoDTO produtoDTO = new ProdutoDTO(
					produto.getId(),
					produto.getNome(),
					produto.getDescricao(),
					produto.getCategoria().name(),
					produto.getPrecoUnitario()
				);
		
		
		return produtoDTO;
	}
	
}
