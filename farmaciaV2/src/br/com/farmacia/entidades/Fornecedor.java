package br.com.farmacia.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.farmacia.generics.GenericEntity;

@Entity
@Table(name = "TB_FARMACIA_FORNECEDOR")
public class Fornecedor extends GenericEntity {

	private static final long serialVersionUID = 6091984940990541385L;

	// ATRIBUTOS

	@Id
	@Column(name = "ID_FORNECEDOR")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "DS_NOME")
	private String nome;

	@Column(name = "NU_CNPJ")
	private String cnpj;

	// RELACIONAMENTOS

	@OneToMany(mappedBy = "fornecedor")
	private List<Produto> produtoList;

	// GET E SET
	@Override
	public Serializable obterIdentificador() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public List<Produto> getProdutoList() {
		return produtoList;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Fornecedor other = (Fornecedor) obj;

		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
