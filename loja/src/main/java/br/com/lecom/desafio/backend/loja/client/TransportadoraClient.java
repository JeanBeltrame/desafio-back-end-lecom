package br.com.lecom.desafio.backend.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.lecom.desafio.backend.loja.dto.EntregaDTO;
import br.com.lecom.desafio.backend.loja.dto.VendaDTO;

@FeignClient("transportadora")
public interface TransportadoraClient {
	
	@RequestMapping(value = "/venda", method = RequestMethod.POST)
	EntregaDTO realizaCompra(VendaDTO venda);

	
	
}
