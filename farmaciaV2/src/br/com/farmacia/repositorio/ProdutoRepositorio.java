package br.com.farmacia.repositorio;

import javax.ejb.Stateless;

import br.com.farmacia.dao.CustomGenericDAOImpl;
import br.com.farmacia.entidades.Produto;
import br.com.farmacia.generics.GenericEntity;

@Stateless
public class ProdutoRepositorio extends CustomGenericDAOImpl<Produto> {

	private static final long serialVersionUID = 1L;

	@Override
	public Class<? extends GenericEntity> obterClasse() {
		return Produto.class;
	}

}