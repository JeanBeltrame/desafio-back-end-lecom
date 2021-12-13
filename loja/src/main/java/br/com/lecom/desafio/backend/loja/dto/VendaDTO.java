package br.com.lecom.desafio.backend.loja.dto;

import java.util.List;

import br.com.lecom.desafio.backend.loja.model.Venda;

public class VendaDTO {

	private Long vendaId;

	private String CepDestinatario;
	
	private List<VendaItemDTO> itens;

	public VendaDTO() {

	}

	public VendaDTO(Long vendaId, String cepDestinatario) {
		this.vendaId = vendaId;
		this.CepDestinatario = cepDestinatario;
	}

	public VendaDTO(Venda venda) {
		this.vendaId = venda.getId();
		this.CepDestinatario = venda.getDestino();
	}

	public Long getvendaId() {
		return vendaId;
	}

	public void setvendaId(Long id) {
		this.vendaId = id;
	}

	public String getCepDestinatario() {
		return CepDestinatario;
	}

	public void setCepDestinatario(String CepDestinatario) {
		this.CepDestinatario = CepDestinatario;
	}

	public List<VendaItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<VendaItemDTO> itens) {
		this.itens = itens;
	}

}
