package br.com.farmacia.vo;

import java.io.Serializable;

import br.com.farmacia.entidades.Produto;

public class ProdutoVo implements Serializable {

	private static final long serialVersionUID = -5002662387410084825L;
	
	private double quantidade;
	private Produto produto;

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
