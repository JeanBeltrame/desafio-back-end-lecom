package br.com.lecom.desafio.backend.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lecom.desafio.backend.loja.client.CatalogoClient;
import br.com.lecom.desafio.backend.loja.dto.ProdutoDTO;

@Service
public class ProdutoService {

	@Autowired
	private CatalogoClient catalogoClient;
	
	public List<ProdutoDTO> todosProdutos() {
		return catalogoClient.getTodosProdutos();
	}

	public ResponseEntity<ProdutoDTO> buscarProdutoPorId(Long id) {
		try {
			return catalogoClient.getProdutoPorId(id);			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	public List<ProdutoDTO> buscarProdutoPorNome(String nome) {
		return catalogoClient.getProdutoPorNome(nome);
	}
	
}
