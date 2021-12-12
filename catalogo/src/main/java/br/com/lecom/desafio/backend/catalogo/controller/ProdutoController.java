package br.com.lecom.desafio.backend.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lecom.desafio.backend.catalogo.model.Produto;
import br.com.lecom.desafio.backend.catalogo.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public List<Produto> todosProdutos() {
		return produtoService.getTodosProdutos();
	}
	
	@RequestMapping(value = "/consultar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id){
		return produtoService.getProdutoPorId(id);
	}
	
}
