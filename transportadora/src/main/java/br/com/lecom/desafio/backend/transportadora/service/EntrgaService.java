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

	public EntregaDTO registrarEntrega(EntregaDTO entregaDTO) {
		Entrega entrega = toEntrega(entregaDTO);
		
		entrega.setStatus(VendaStatus.EM_PREPARO);
		entrega.setCepRemetente("17033570");

		entregaRepository.save(entrega);

		toEntregaDTO(entrega);

		return toEntregaDTO(entrega);
	}

	private EntregaDTO toEntregaDTO(Entrega entrega) {
		EntregaDTO entregaDTO = new EntregaDTO(
				entrega.getId(),
				entrega.getVendaId(),
				entrega.getCepRemetente(),
				entrega.getCepDestinatario(),
				entrega.getStatus().name());
		return entregaDTO;
	}

	private Entrega toEntrega(EntregaDTO entregaDTO) {
		Entrega entrega = new Entrega();

		entrega.setId(entregaDTO.getId());
		entrega.setVendaId(entregaDTO.getVendaId());
		entrega.setCepDestinatario(entregaDTO.getCepDestinatario());

		return entrega;
	}

}
