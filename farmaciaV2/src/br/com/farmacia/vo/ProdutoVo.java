package br.com.farmacia.vo;

import br.com.farmacia.entidades.Produto;

public class ProdutoVo {

	public float quantidade;
	public Produto produto;

	public float getQuantidade() {
		return quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
