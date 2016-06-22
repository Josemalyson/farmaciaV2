package br.com.farmacia.repositorio;

import javax.ejb.Stateless;

import br.com.farmacia.dao.CustomGenericDAOImpl;
import br.com.farmacia.entidades.Cliente;
import br.com.farmacia.generics.GenericEntity;

@Stateless
public class ClienteRepositorio extends CustomGenericDAOImpl<Cliente>{

	private static final long serialVersionUID = 1L;

	@Override
	public Class<? extends GenericEntity> obterClasse() {
		return Cliente.class;
	}

}
