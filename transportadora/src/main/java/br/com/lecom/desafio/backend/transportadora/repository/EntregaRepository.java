package br.com.lecom.desafio.backend.transportadora.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.lecom.desafio.backend.transportadora.model.Entrega;

public interface EntregaRepository extends CrudRepository<Entrega, Long>{

	List<Entrega> findAllByOrderByIdDesc();

}
