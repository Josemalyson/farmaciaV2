package br.com.farmacia.servicos;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.farmacia.entidades.Pedido;
import br.com.farmacia.repositorio.PedidoRepositorio;

public class PedidoServico implements Serializable {

	private static final long serialVersionUID = -2926719468007590581L;
	@Inject
	private PedidoRepositorio pedidoRepositorio;
	@Inject
	private ProdutoPedidoServico produtoPedidoServico;
	@Inject
	private ClienteServico clienteServico;
	@Inject
	private ProdutoServico produtoServico;

	@Transactional
	public void excluir(Pedido pedido) {

	}

	public Pedido consultarPorId(Pedido pedido) {
		return pedidoRepositorio.consultarPorId(pedido);
	}

	@Transactional
	public void salvar(Pedido pedidoBD) {
		pedidoRepositorio.salvar(pedidoBD);

	}

}
