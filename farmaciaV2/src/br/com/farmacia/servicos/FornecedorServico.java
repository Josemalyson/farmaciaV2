package br.com.farmacia.servicos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.farmacia.entidades.Fornecedor;
import br.com.farmacia.repositorio.FornecedorRepositorio;

public class FornecedorServico implements Serializable {

	private static final long serialVersionUID = 4806862435948739858L;

	@Inject
	private FornecedorRepositorio fornecedorRepositorio;

	@Transactional
	public void salvar(Fornecedor fornecedor) {
		fornecedorRepositorio.salvar(fornecedor);
	}

	@Transactional
	public void excluir(Fornecedor fornecedor) {
		fornecedorRepositorio.excluir(fornecedor);
	}

	public List<Fornecedor> listar() {
		return fornecedorRepositorio.listar();
	}

}
