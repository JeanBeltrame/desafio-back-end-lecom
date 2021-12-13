package br.com.lecom.desafio.backend.transportadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lecom.desafio.backend.transportadora.dto.EntregaDTO;
import br.com.lecom.desafio.backend.transportadora.model.Entrega;
import br.com.lecom.desafio.backend.transportadora.service.EntrgaService;

@RestController
@RequestMapping("/venda")
public class EntregaController {
	
	@Autowired
	private EntrgaService entregaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Entrega registrarEntrega(@RequestBody EntregaDTO entrega) {
		return entregaService.registrarEntrega(entrega);
	}

}
