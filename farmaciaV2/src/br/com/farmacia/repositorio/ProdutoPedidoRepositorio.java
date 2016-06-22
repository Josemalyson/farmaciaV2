package br.com.farmacia.repositorio;

import javax.ejb.Stateless;

import br.com.farmacia.dao.CustomGenericDAOImpl;
import br.com.farmacia.entidades.ProdutoPedido;
import br.com.farmacia.generics.GenericEntity;

@Stateless
public class ProdutoPedidoRepositorio extends CustomGenericDAOImpl<ProdutoPedido> {

	private static final long serialVersionUID = 1L;

	@Override
	public Class<? extends GenericEntity> obterClasse() {
		return ProdutoPedido.class;
	}

}