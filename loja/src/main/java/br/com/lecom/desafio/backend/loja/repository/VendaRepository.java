package br.com.lecom.desafio.backend.loja.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.lecom.desafio.backend.loja.model.Venda;

public interface VendaRepository extends CrudRepository<Venda, Long>{

	List<Venda> findAll();
	
}
