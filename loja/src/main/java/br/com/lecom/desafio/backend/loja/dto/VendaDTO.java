package br.com.lecom.desafio.backend.loja.dto;

import java.util.List;

import br.com.lecom.desafio.backend.loja.model.VendaStatus;

public class VendaDTO {

	private Long id;
	
	private List<VendaItemDTO> itens; // vai ter que criar um VendaItemDTO para passar a quantidade de produtos
	
	private VendaStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<VendaItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<VendaItemDTO> itens) {
		this.itens = itens;
	}

	public VendaStatus getStatus() {
		return status;
	}

	public void setStatus(VendaStatus status) {
		this.status = status;
	}

}
