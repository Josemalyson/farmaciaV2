package br.com.farmacia.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.farmacia.generics.GenericEntity;

@SuppressWarnings("unchecked")
public abstract class GenericDAOImpl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8483222232120209205L;
	@PersistenceContext
	private EntityManager entityManager;

	
	public Collection<? extends GenericEntity> listar() {
		String query = "SELECT T FROM " + obterClasse().getSimpleName() + " T";
		return this.entityManager.createQuery(query).getResultList();
	}

	public GenericEntity salvar(GenericEntity objeto) {
		return this.entityManager.merge(objeto);
	}

	public void excluir(GenericEntity objeto) {
		this.entityManager.remove(this.entityManager.getReference(
				obterClasse(), objeto.obterIdentificador()));
	}

	public GenericEntity consultarPorId(GenericEntity objeto) {
		return this.entityManager.find(obterClasse(),
				objeto.obterIdentificador());
	}

	public abstract Class<? extends GenericEntity> obterClasse();

	public EntityManager obterEntityManager() {
		return this.entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}