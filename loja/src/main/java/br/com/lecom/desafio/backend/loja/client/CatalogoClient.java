package br.com.lecom.desafio.backend.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.lecom.desafio.backend.loja.dto.ProdutoDTO;

@FeignClient("catalogo")
public interface CatalogoClient {
	
	@RequestMapping(value = "/produto/consultar", method = RequestMethod.GET)
	List<ProdutoDTO> getTodosProdutos();

	@RequestMapping("/produto/consultar/{id}")
	ResponseEntity<ProdutoDTO> getProdutoPorId(@PathVariable Long id);

}
