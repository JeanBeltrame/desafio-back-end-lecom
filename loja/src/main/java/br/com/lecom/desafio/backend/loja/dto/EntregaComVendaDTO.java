package br.com.lecom.desafio.backend.loja.dto;

import java.util.List;

public class EntregaComVendaDTO {

	private List<String> nomeProduto;

	private String cepDestinatario;
	private String cepRemetente;

	private String status;


	public String getCepDestinatario() {
		return cepDestinatario;
	}

	public void setCepDestinatario(String cepDestinatario) {
		this.cepDestinatario = cepDestinatario;
	}

	public String getCepRemetente() {
		return cepRemetente;
	}

	public void setCepRemetente(String cepRemetente) {
		this.cepRemetente = cepRemetente;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(List<String> nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

}
