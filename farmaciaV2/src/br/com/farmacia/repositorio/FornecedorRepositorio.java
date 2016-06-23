package br.com.farmacia.repositorio;

import javax.persistence.Query;

import br.com.farmacia.dao.CustomGenericDAOImpl;
import br.com.farmacia.entidades.Fornecedor;
import br.com.farmacia.entidades.Produto;
import br.com.farmacia.generics.GenericEntity;

public class FornecedorRepositorio extends CustomGenericDAOImpl<Fornecedor> {

	private static final long serialVersionUID = -473756208391653333L;

	@Override
	public Class<? extends GenericEntity> obterClasse() {
		return Fornecedor.class;
	}

	public Fornecedor buscarFornecedorPorIdProduto(Produto produto) {
		StringBuilder consulta = new StringBuilder();

		consulta.append(" SELECT f.* FROM tb_farmacia_fornecedor f inner join tb_farmacia_produto p ")
				.append(" on f.ID_FORNECEDOR = p.fornecedor_ID_FORNECEDOR where p.ID_PRODUTO =:produto ");

		Query query = obterEntityManager().createNativeQuery(consulta.toString(), Fornecedor.class);
		query.setParameter("produto", produto.getId());
		return (Fornecedor) query.getSingleResult();
	}

}
