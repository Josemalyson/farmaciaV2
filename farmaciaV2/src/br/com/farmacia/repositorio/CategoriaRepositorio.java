package br.com.farmacia.repositorio;

import javax.persistence.Query;

import br.com.farmacia.dao.CustomGenericDAOImpl;
import br.com.farmacia.entidades.Categoria;
import br.com.farmacia.entidades.Produto;
import br.com.farmacia.generics.GenericEntity;

public class CategoriaRepositorio extends CustomGenericDAOImpl<Categoria> {

	private static final long serialVersionUID = -2371397544492875576L;

	@Override
	public Class<? extends GenericEntity> obterClasse() {
		return Categoria.class;
	}

	public Categoria buscarCategoriaPorIdProduto(Produto produto) {
		StringBuilder consulta = new StringBuilder();
		
		consulta
			.append(" SELECT c.* FROM tb_farmacia_categoria c inner join tb_farmacia_produto p ")
			.append(" on c.ID_CATEGORIA = p.categoria_ID_CATEGORIA where p.ID_PRODUTO =:produto ");
			
		Query query = obterEntityManager().createNativeQuery(consulta.toString(),Categoria.class);
		query.setParameter("produto", produto.getId());
		return (Categoria) query.getSingleResult();
	}

}
