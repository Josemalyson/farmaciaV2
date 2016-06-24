package br.com.farmacia.controlador;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.DoubleStream;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.farmacia.constantes.Constantes;
import br.com.farmacia.constantes.MsgConstantes;
import br.com.farmacia.entidades.Cliente;
import br.com.farmacia.entidades.Produto;
import br.com.farmacia.servicos.ClienteServico;
import br.com.farmacia.servicos.PedidoServico;
import br.com.farmacia.servicos.ProdutoServico;
import br.com.farmacia.vo.ProdutoVo;
import br.com.farmacia.vo.VendaVo;

@ManagedBean
@ViewScoped
public class PedidoControlador extends CoreControlador {

	private static final long serialVersionUID = -5526946400684258997L;

	private VendaVo vendaVo;

	@Inject
	private ProdutoServico produtoServico;
	@Inject
	private ClienteServico clienteServico;
	@Inject
	private PedidoServico pedidoServico;

	@PostConstruct
	public void init() {
		vendaVo = new VendaVo();
		vendaVo.setDtPedido(new Date());
		vendaVo.setProdutoVoList(new ArrayList<>());
	}

	public List<Produto> autoCompleteProduto(String query) {
		List<Produto> produtoList = produtoServico.listar();
		List<Produto> produtoListFiltrados = new ArrayList<>();

		for (Produto produto : produtoList) {
			if (produto.getDescricaoProduto().contains(query)) {
				produtoListFiltrados.add(produto);
			}
		}

		return produtoListFiltrados;
	}

	public List<Cliente> autoCompleteCliente(String query) {
		List<Cliente> clienteList = clienteServico.listar();
		List<Cliente> clienteListFiltrados = new ArrayList<>();

		for (Cliente cliente : clienteList) {
			if (cliente.getNome().contains(query)) {
				clienteListFiltrados.add(cliente);
			}
		}

		return clienteListFiltrados;
	}

	public void calcularValorTotalDaCompra() {
		DoubleStream totalCompra = this.vendaVo.getProdutoVoList().stream().mapToDouble(produtoVo -> (produtoVo
				.getProduto().getPrecoVenda().multiply(BigDecimal.valueOf(produtoVo.getQuantidade()))).doubleValue());
		this.vendaVo.setTotalDaCompra(BigDecimal.valueOf(totalCompra.sum()));

	}

	public void calcularDesconto(){
		this.vendaVo.setTotalDaVenda(this.vendaVo.getTotalDaCompra().subtract(this.vendaVo.getValorDesconto()));
	}
	
	public void adiconarProduto() {
		ProdutoVo produtoVo = new ProdutoVo();
		produtoVo.setProduto(this.vendaVo.getProduto());
		produtoVo.setQuantidade(0);
		this.vendaVo.getProdutoVoList().add(produtoVo);
		this.vendaVo.setProduto(new Produto());
		this.vendaVo.setTotalDaVenda(this.vendaVo.getTotalDaCompra().subtract(this.vendaVo.getValorDesconto()));
		calcularValorTotalDaCompra();
	}

	public String salvar() {
		pedidoServico.salvar(this.vendaVo);
		adicionarMensagem(MsgConstantes.MSG_SUCESSO);
		return sendRedirect(Constantes.PAGINA_INICIO);
	}

	public VendaVo getVendaVo() {
		return vendaVo;
	}

	public void setVendaVo(VendaVo vendaVo) {
		this.vendaVo = vendaVo;
	}

}
