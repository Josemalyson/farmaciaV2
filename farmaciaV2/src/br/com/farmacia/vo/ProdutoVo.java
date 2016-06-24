package br.com.farmacia.vo;

import br.com.farmacia.entidades.Produto;

public class ProdutoVo {

	public double quantidade;
	public Produto produto;

	public double getQuantidade() {
		return quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
