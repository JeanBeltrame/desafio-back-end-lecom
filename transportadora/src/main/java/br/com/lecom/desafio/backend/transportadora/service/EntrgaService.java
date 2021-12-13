package br.com.lecom.desafio.backend.transportadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lecom.desafio.backend.transportadora.dto.EntregaDTO;
import br.com.lecom.desafio.backend.transportadora.model.Entrega;
import br.com.lecom.desafio.backend.transportadora.model.VendaStatus;
import br.com.lecom.desafio.backend.transportadora.repository.EntregaRepository;

@Service
public class EntrgaService {

	@Autowired
	EntregaRepository entregaRepository;
	
	public Entrega registrarEntrega(EntregaDTO entregaDTO) {
		Entrega entrega = toEntrega(entregaDTO);
		entrega.setStatus(VendaStatus.EM_PREPARO);
		entrega.setCepRemetente("17033570");
		
		return entregaRepository.save(entrega);
	}
	
	private Entrega toEntrega(EntregaDTO entregaDTO) {
		Entrega entrega = new Entrega();
		
		entrega.setId(entregaDTO.getId());
		entrega.setVendaId(entregaDTO.getVendaId());
		
		return entrega;
	}

}
