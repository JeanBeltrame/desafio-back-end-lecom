package br.com.lecom.desafio.backend.transportadora.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entrega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long vendaId;
	
	private String CepDestinatario;

	private String CepRemetente;
	
	@Enumerated(EnumType.STRING)
	private VendaStatus status;

	public Entrega() {

	}
	
	public Entrega(Long id, Long vendaId, String cepDestinatario, String cepRemetente, VendaStatus status) {
		this.id = id;
		this.vendaId = vendaId;
		this.CepDestinatario = cepDestinatario;
		this.CepRemetente = cepRemetente;
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
	
	public String getCepDestinatario() {
		return CepDestinatario;
	}

	public void setCepDestinatario(String cepDestinatario) {
		CepDestinatario = cepDestinatario;
	}

	public String getCepRemetente() {
		return CepRemetente;
	}

	public void setCepRemetente(String cepRemetente) {
		CepRemetente = cepRemetente;
	}
	
	public VendaStatus getStatus() {
		return status;
	}

	public void setStatus(VendaStatus status) {
		this.status = status;
	}

	

}
