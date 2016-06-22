package br.com.farmacia.repositorio;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import br.com.farmacia.dao.CustomGenericDAOImpl;
import br.com.farmacia.entidades.Usuario;
import br.com.farmacia.generics.GenericEntity;

@Stateless
public class UsuarioRepositorio extends CustomGenericDAOImpl<Usuario> {

	private static final long serialVersionUID = 1L;

	@Override
	public Class<? extends GenericEntity> obterClasse() {
		return Usuario.class;
	}

	public Usuario consultarUsuarioPorNome(String nome) {
		StringBuilder consulta = new StringBuilder();
		consulta.append("SELECT * FROM tb_farmacia_usuario where nome = :nome ");
		Query query = obterEntityManager().createNativeQuery(consulta.toString(), Usuario.class);
		query.setParameter("nome", nome);

		try {
			return (Usuario) query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			return null;
		}

	}

}