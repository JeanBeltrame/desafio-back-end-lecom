package br.com.lecom.desafio.backend.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lecom.desafio.backend.loja.dto.ProdutoDTO;
import br.com.lecom.desafio.backend.loja.service.ProdutoService;

@RestController
@RequestMapping("/produto")

public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public List<ProdutoDTO> todosProdutos() {
		return produtoService.todosProdutos();
	}
	
//	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/consultar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
		return produtoService.buscarProdutoPorId(id); //ResponseEntity.notFound().build()
	}
}
