package br.com.lecom.desafio.backend.loja.dto;

public class EntregaDTO {

	private Long id;
	private Long vendaId;
	
	private String CepRemetente;
	private String cepDestinatario;
	
	private String status;

	public EntregaDTO() {

	}

	public EntregaDTO(Long id, Long vendaId, String cepRemetente, String cepDestinatario, String status) {
		this.id = id;
		this.vendaId = vendaId;
		this.CepRemetente = cepRemetente;
		this.cepDestinatario = cepDestinatario;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVendaId() {
		return vendaId;
	}

	public void setVendaId(Long vendaId) {
		this.vendaId = vendaId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCepDestinatario() {
		return cepDestinatario;
	}

	public void setCepDestinatario(String cepDestinatario) {
		this.cepDestinatario = cepDestinatario;
	}

	public String getCepRemetente() {
		return CepRemetente;
	}

	public void setCepRemetente(String cepRemetente) {
		CepRemetente = cepRemetente;
	}
	
	
}
