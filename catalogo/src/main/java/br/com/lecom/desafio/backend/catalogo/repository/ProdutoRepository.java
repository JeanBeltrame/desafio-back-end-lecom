package br.com.lecom.desafio.backend.catalogo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.lecom.desafio.backend.catalogo.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	List<Produto> findAll();
	
	Optional<Produto> findById(Long id);
	
	List<Produto> findByIdIn(List<Long> ids);
	
}
