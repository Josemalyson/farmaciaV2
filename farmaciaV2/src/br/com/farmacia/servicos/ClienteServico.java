package br.com.farmacia.servicos;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.farmacia.entidades.Cliente;
import br.com.farmacia.repositorio.ClienteRepositorio;

public class ClienteServico implements Serializable {

	private static final long serialVersionUID = 4806862435948739858L;

	@Inject
	private ClienteRepositorio clienteRepositorio;

	@Transactional
	public void salvar(Cliente cliente) {
		clienteRepositorio.salvar(cliente);
	}

	@Transactional
	public void excluir(Cliente cliente) {
		clienteRepositorio.excluir(cliente);
	}

}
