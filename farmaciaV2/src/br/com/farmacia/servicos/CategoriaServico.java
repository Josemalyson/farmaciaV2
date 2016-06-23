package br.com.farmacia.servicos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.farmacia.entidades.Categoria;
import br.com.farmacia.entidades.Produto;
import br.com.farmacia.repositorio.CategoriaRepositorio;

public class CategoriaServico implements Serializable {

	private static final long serialVersionUID = 4806862435948739858L;

	@Inject
	private CategoriaRepositorio categoriaRepositorio;

	@Transactional
	public void salvar(Categoria categoria) {
		categoriaRepositorio.salvar(categoria);
	}

	@Transactional
	public void excluir(Categoria categoria) {
		categoriaRepositorio.excluir(categoria);
	}

	public List<Categoria> listar() {
		return categoriaRepositorio.listar();
	}

	public Categoria buscarCategoriaPorIdProduto(Produto produto) {
		return categoriaRepositorio. buscarCategoriaPorIdProduto(produto);
	}

}
