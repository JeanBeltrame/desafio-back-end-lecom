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

	@RequestMapping(value = "/produto/consultar/{id}", method = RequestMethod.GET)
	ResponseEntity<ProdutoDTO> getProdutoPorId(@PathVariable Long id);

	@RequestMapping(value = "produto/consultar", method = RequestMethod.POST)
	List<ProdutoDTO> getVariosProdutosPorId(List<Long> idsProdutos);

	@RequestMapping(value = "/produto/consultar/nome/{nome}", method = RequestMethod.GET)
	List<ProdutoDTO> getProdutoPorNome(@PathVariable String nome);

}
