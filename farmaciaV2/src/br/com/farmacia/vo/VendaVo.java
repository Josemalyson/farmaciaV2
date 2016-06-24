package br.com.farmacia.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.farmacia.entidades.Cliente;
import br.com.farmacia.entidades.Produto;

public class VendaVo implements Serializable {

	private static final long serialVersionUID = 1049660646230327825L;
	
	public Produto produto;
	public Cliente cliente;
	public Date dtPedido;
	public List<ProdutoVo> produtoVoList;
	public BigDecimal valorDesconto;
	public BigDecimal totalDaCompra;
	public BigDecimal totalDeDesconto;
	public BigDecimal totalDaVenda;

	public Produto getProduto() {
		return produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Date getDtPedido() {
		return dtPedido;
	}

	public List<ProdutoVo> getProdutoVoList() {
		return produtoVoList;
	}

	public BigDecimal getTotalDaCompra() {
		return totalDaCompra;
	}

	public BigDecimal getTotalDeDesconto() {
		return totalDeDesconto;
	}

	public BigDecimal getTotalDaVenda() {
		return totalDaVenda;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}

	public void setProdutoVoList(List<ProdutoVo> produtoVoList) {
		this.produtoVoList = produtoVoList;
	}

	public void setTotalDaCompra(BigDecimal totalDaCompra) {
		this.totalDaCompra = totalDaCompra;
	}

	public void setTotalDeDesconto(BigDecimal totalDeDesconto) {
		this.totalDeDesconto = totalDeDesconto;
	}

	public void setTotalDaVenda(BigDecimal totalDaVenda) {
		this.totalDaVenda = totalDaVenda;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

}
