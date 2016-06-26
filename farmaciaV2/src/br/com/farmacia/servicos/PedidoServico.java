package br.com.farmacia.servicos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.farmacia.entidades.Pedido;
import br.com.farmacia.entidades.ProdutoPedido;
import br.com.farmacia.entidades.ProdutoPedidoPK;
import br.com.farmacia.repositorio.PedidoRepositorio;
import br.com.farmacia.vo.ProdutoVo;
import br.com.farmacia.vo.VendaVo;

public class PedidoServico implements Serializable {

	private static final long serialVersionUID = -2926719468007590581L;
	@Inject
	private PedidoRepositorio pedidoRepositorio;
	@Inject
	private ProdutoPedidoServico produtoPedidoServico;

	public Pedido consultarPorId(Pedido pedido) {
		return pedidoRepositorio.consultarPorId(pedido);
	}

	@Transactional
	public void salvar(VendaVo vendaVo) {
		Pedido pedido = new Pedido();
		pedido.setCliente(vendaVo.getCliente());
		pedido.setDesconto(vendaVo.getValorDesconto());
		pedido.setDtPedido(vendaVo.getDtPedido());
		pedido.setTotalVenda(vendaVo.getTotalDaVenda());
		pedido.setValorTotal(vendaVo.getTotalDaCompra());
		Pedido pedidoBD = pedidoRepositorio.salvar(pedido);

		for (ProdutoVo produtoVo : vendaVo.getProdutoVoList()) {
			ProdutoPedidoPK produtoPedidoPK = new ProdutoPedidoPK();
			produtoPedidoPK.setIdPedido(pedidoBD.getId());
			produtoPedidoPK.setIdProduto(produtoVo.getProduto().getId());
			ProdutoPedido produtoPedido = new ProdutoPedido();
			produtoPedido.setId(produtoPedidoPK);
			produtoPedido.setQtdProduto((int) produtoVo.getQuantidade());
			produtoPedidoServico.salvar(produtoPedido);
		}
	}

	public List<Pedido> litar() {
		return pedidoRepositorio.listar();
	}

}
