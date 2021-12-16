package br.com.lecom.desafio.backend.loja.dto;

import java.math.BigDecimal;
import java.util.List;

public class VendaDTO {

	private Long vendaId;

	private String cepDestinatario;
	
	private List<VendaItemDTO> itens;
	
	private BigDecimal precoTotal;

	public VendaDTO() {

	}

	public VendaDTO(Long vendaId, String cepDestinatario) {
		this.vendaId = vendaId;
		this.cepDestinatario = cepDestinatario;
	}


	public Long getVendaId() {
		return vendaId;
	}

	public void setVendaId(Long id) {
		this.vendaId = id;
	}

	public String getCepDestinatario() {
		return cepDestinatario;
	}

	public void setCepDestinatario(String cepDestinatario) {
		this.cepDestinatario = cepDestinatario;
	}

	public List<VendaItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<VendaItemDTO> itens) {
		this.itens = itens;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

}
