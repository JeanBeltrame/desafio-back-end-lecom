package br.com.lecom.desafio.backend.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lecom.desafio.backend.loja.dto.EntregaComVendaDTO;
import br.com.lecom.desafio.backend.loja.dto.EntregaDTO;
import br.com.lecom.desafio.backend.loja.dto.VendaDTO;
import br.com.lecom.desafio.backend.loja.service.VendaService;


@RestController
@RequestMapping("/venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@CrossOrigin
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public List<VendaDTO> todasVendas() {
		return vendaService.todasVendas();
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public EntregaDTO realizaCompra(@RequestBody VendaDTO venda) {
		return vendaService.realizaCompra(venda);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/consultar/entrega", method = RequestMethod.GET)
	public List<EntregaComVendaDTO> todasEntregas() {
		return vendaService.todasEntregas();
	}

}
