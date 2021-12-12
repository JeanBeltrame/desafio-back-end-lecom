package br.com.lecom.desafio.backend.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lecom.desafio.backend.loja.model.Venda;
import br.com.lecom.desafio.backend.loja.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	public List<Venda> todasVendas() {
		return vendaRepository.findAll();
	}
	
}
