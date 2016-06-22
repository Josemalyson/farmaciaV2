package br.com.farmacia.repositorio;

import br.com.farmacia.dao.CustomGenericDAOImpl;
import br.com.farmacia.entidades.Fornecedor;
import br.com.farmacia.generics.GenericEntity;

public class FornecedorRepositorio extends CustomGenericDAOImpl<Fornecedor> {


	private static final long serialVersionUID = -473756208391653333L;

	@Override
	public Class<? extends GenericEntity> obterClasse() {
		return Fornecedor.class;
	}

}
