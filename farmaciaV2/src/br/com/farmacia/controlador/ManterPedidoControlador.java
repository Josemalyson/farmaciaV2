package br.com.farmacia.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.farmacia.entidades.Pedido;
import br.com.farmacia.servicos.PedidoServico;

@ManagedBean
@ViewScoped
public class ManterPedidoControlador extends CoreControlador {

	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoServico pedidoServico;

	private List<Pedido> pedidoList;

	@PostConstruct
	public void init() {
		listarPedidos();
	}

	private void listarPedidos() {
		this.pedidoList = pedidoServico.litar();
	}

	public List<Pedido> getPedidoList() {
		return pedidoList;
	}

	public void setPedidoList(List<Pedido> pedidoList) {
		this.pedidoList = pedidoList;
	}

}
