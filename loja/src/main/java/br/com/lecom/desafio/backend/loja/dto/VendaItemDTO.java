package br.com.lecom.desafio.backend.loja.dto;

public class VendaItemDTO {

	private Integer quantidade;
	
	private ProdutoDTO produto;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
	
}
