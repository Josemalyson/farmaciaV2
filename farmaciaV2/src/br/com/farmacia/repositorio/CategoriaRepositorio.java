package br.com.farmacia.repositorio;

import br.com.farmacia.dao.CustomGenericDAOImpl;
import br.com.farmacia.entidades.Categoria;
import br.com.farmacia.generics.GenericEntity;

public class CategoriaRepositorio extends CustomGenericDAOImpl<Categoria> {

	private static final long serialVersionUID = -2371397544492875576L;

	@Override
	public Class<? extends GenericEntity> obterClasse() {
		return Categoria.class;
	}

}
