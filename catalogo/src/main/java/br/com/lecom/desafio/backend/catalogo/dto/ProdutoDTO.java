package br.com.lecom.desafio.backend.catalogo.dto;

import java.math.BigDecimal;

import javax.persistence.Table;

@Table(name = "produto")
public class ProdutoDTO {

	private Long id;

	private String nome;
	private String descricao;
	private String categoria;

	private BigDecimal precoUnitario;

	public ProdutoDTO() {

	}
	
	public ProdutoDTO(Long id, String nome, String descricao, String categoria, BigDecimal precoUnitario) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.precoUnitario = precoUnitario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
