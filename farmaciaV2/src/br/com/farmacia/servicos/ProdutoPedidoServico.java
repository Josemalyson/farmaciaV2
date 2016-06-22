package br.com.farmacia.servicos;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.farmacia.repositorio.ProdutoPedidoRepositorio;

public class ProdutoPedidoServico implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1130196879582890093L;
	@Inject
	private ProdutoPedidoRepositorio produtoPedidoRepositorio;
	
	
}
