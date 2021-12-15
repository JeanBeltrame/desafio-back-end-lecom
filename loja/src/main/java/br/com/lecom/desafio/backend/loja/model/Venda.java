package br.com.lecom.desafio.backend.loja.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendaId")
	private List<VendaItem> itens;
	
	private String cepDestinatario;
	
	private BigDecimal precoTotal;

	
	public Venda() {

	}

	public Venda(Long id, List<VendaItem> itens, String cepDestinatario, BigDecimal precoTotal) {
		this.id = id;
		this.itens = itens;
		this.cepDestinatario = cepDestinatario;
		this.precoTotal = precoTotal;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<VendaItem> getItens() {
		return itens;
	}

	public void setItens(List<VendaItem> itens) {
		this.itens = itens;
	}

	public String getCepDestinatario() {
		return cepDestinatario;
	}

	public void setCepDestinatario(String cepDestinatario) {
		this.cepDestinatario = cepDestinatario;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

}
