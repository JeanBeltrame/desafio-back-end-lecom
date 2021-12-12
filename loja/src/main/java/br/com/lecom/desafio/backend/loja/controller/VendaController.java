package br.com.lecom.desafio.backend.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lecom.desafio.backend.loja.model.Venda;
import br.com.lecom.desafio.backend.loja.service.VendaService;


@RestController
@RequestMapping("/venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public List<Venda> todasVendas() { //vendaDTO
		return vendaService.todasVendas();
	}

}
