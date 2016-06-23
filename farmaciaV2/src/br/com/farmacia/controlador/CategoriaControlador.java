package br.com.farmacia.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.farmacia.constantes.MsgConstantes;
import br.com.farmacia.entidades.Categoria;
import br.com.farmacia.servicos.CategoriaServico;

@ManagedBean
public class CategoriaControlador extends CoreControlador {

	private static final long serialVersionUID = -5526946400684258997L;

	@Inject
	private CategoriaServico categoriaServico;
	private List<Categoria> categoriaList;
	private Categoria categoria;

	@PostConstruct
	public void init() {
		listarCategoria();
		categoria = new Categoria();
	}

	private void listarCategoria() {
		this.categoriaList = categoriaServico.listar();
	}

	public void salvar() {
		categoriaServico.salvar(this.categoria);
		listarCategoria();
		adicionarMensagem(MsgConstantes.MSG_SUCESSO);
	}

	public void novaCategoria() {
		this.categoria = new Categoria();
	}

	public void excluirCategoria(Categoria categoria) {
		categoriaServico.excluir(categoria);
		listarCategoria();
		adicionarMensagem(MsgConstantes.MSG_SUCESSO);
	}

	public List<Categoria> getCategoriaList() {
		return categoriaList;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoriaList(List<Categoria> categoriaList) {
		this.categoriaList = categoriaList;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
