package br.com.farmacia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.farmacia.generics.GenericEntity;

@Entity
@Table(name = "TB_FARMACIA_PRODUTO_PEDIDO")
public class ProdutoPedido extends GenericEntity {

	private static final long serialVersionUID = 2222086674667477421L;

	@ManyToOne
	@JoinColumn(name = "FK_PRODUTO", referencedColumnName = "ID_PRODUTO", insertable = false, updatable = false)
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "FK_PEDIDO", referencedColumnName = "ID_PEDIDO", insertable = false, updatable = false)
	private Pedido pedido;

	@Column(name = "NU_QTD_PRODUTO")
	private Integer qtdProduto;

	@EmbeddedId
	private ProdutoPedidoPK id;

	public Serializable obterIdentificador() {
		return id;
	}

	public ProdutoPedidoPK getId() {
		return id;
	}

	public void setId(ProdutoPedidoPK id) {
		this.id = id;
	}

	public Integer getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Integer qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

}
