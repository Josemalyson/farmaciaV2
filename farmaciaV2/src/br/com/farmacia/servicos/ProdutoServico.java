package br.com.farmacia.servicos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.farmacia.entidades.Produto;
import br.com.farmacia.repositorio.ProdutoRepositorio;

public class ProdutoServico implements Serializable {

	private static final long serialVersionUID = 2296788064359833138L;
	@Inject
	private ProdutoRepositorio produtoRepositorio;
	@Inject
	private ProdutoPedidoServico produtoPedidoServico;

	@Transactional
	public void salvarProduto(Produto produto) {
	}

	public List<Produto> listar() {
		List<Produto> produtoList = produtoRepositorio.listar();
		return produtoList;
	}

	@Transactional
	public void excluirProduto(Produto produto) {
		produtoRepositorio.excluir(produto);

	}

	@Transactional
	public void salvar(Produto produto) {
		produtoRepositorio.salvar(produto);

	}

}