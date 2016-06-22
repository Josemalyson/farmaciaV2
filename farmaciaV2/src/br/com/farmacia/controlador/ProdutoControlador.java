package br.com.farmacia.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.farmacia.constantes.MsgConstantes;
import br.com.farmacia.entidades.Categoria;
import br.com.farmacia.entidades.Fornecedor;
import br.com.farmacia.entidades.Produto;
import br.com.farmacia.servicos.CategoriaServico;
import br.com.farmacia.servicos.FornecedorServico;
import br.com.farmacia.servicos.ProdutoServico;

@ManagedBean
public class ProdutoControlador extends CoreControlador {

	private static final long serialVersionUID = -5526946400684258997L;

	@Inject
	private ProdutoServico produtoServico;
	private List<Produto> produtoList;
	private Produto produto;

	@Inject
	private CategoriaServico categoriaServico;
	private Categoria categoria;
	private List<Categoria> categoriaList;

	@Inject
	private FornecedorServico fornecedorServico;
	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedorList;

	@PostConstruct
	public void init() {
		listarProduto();
		listarFornecedor();
		listarCategoria();
		produto = new Produto();
		fornecedor = new Fornecedor();
		categoria = new Categoria();
	}

	private void listarCategoria() {
		categoriaList = categoriaServico.listar();

	}

	private void listarFornecedor() {
		fornecedorList = fornecedorServico.listar();

	}

	private void listarProduto() {
		this.produtoList = produtoServico.listar();
	}

	public void salvar() {
		produtoServico.salvar(this.produto);
		listarProduto();
		adicionarMensagem(MsgConstantes.MSG_SUCESSO);
	}

	public void novoProduto() {
		this.produto = new Produto();
		this.produto.setCategoria(this.categoria);
		this.produto.setFornecedor(this.fornecedor);
	}

	public void excluirProduto(Produto produto) {
		produtoServico.excluirProduto(produto);
		listarProduto();
		adicionarMensagem(MsgConstantes.MSG_SUCESSO);
	}

	public List<Produto> getProdutoList() {
		return produtoList;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public List<Categoria> getCategoriaList() {
		return categoriaList;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public List<Fornecedor> getFornecedorList() {
		return fornecedorList;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setCategoriaList(List<Categoria> categoriaList) {
		this.categoriaList = categoriaList;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void setFornecedorList(List<Fornecedor> fornecedorList) {
		this.fornecedorList = fornecedorList;
	}

}
