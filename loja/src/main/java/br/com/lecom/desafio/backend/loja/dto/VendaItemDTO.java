package br.com.lecom.desafio.backend.loja.dto;

public class VendaItemDTO {

	private Long id;
	private Long vendaId;
	
	private Integer quantidade;
	
	private ProdutoDTO produto;
	
	public VendaItemDTO() {

	}

	public VendaItemDTO(Long id, Long vendaId, Integer quantidade, ProdutoDTO produto) {
		super();
		this.id = id;
		this.vendaId = vendaId;
		this.quantidade = quantidade;
		this.produto = produto;
	}

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
	
}
