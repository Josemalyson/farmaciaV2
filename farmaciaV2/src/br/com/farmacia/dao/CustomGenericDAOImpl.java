package br.com.farmacia.dao;

import java.util.List;

import br.com.farmacia.generics.GenericEntity;

public abstract class CustomGenericDAOImpl<T extends GenericEntity> extends GenericDAOImpl{

	private static final long serialVersionUID = 1L;
	private static final String UNCHECKED = "unchecked";
	
	@Override
	@SuppressWarnings(UNCHECKED)
	public List<T> listar() {
		return (List<T>) super.listar();
	}

	@Override
	@SuppressWarnings(UNCHECKED)
	public T salvar(GenericEntity objeto) {
		return (T) super.salvar(objeto);
	}


	@Override
	@SuppressWarnings(UNCHECKED)
	public T consultarPorId(GenericEntity objeto) {
		return (T) super.consultarPorId(objeto);
	}

}
