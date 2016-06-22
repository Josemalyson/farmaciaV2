package br.com.farmacia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.farmacia.generics.GenericEntity;

@Entity
@Table(name = "TB_FARMACIA_USUARIO")
public class Usuario extends GenericEntity {

	private static final long serialVersionUID = 6091984940990541385L;

	// ATRIBUTOS

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idUsuario")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "senha")
	private String senha;

	// RELACIONAMENTOS

	@OneToOne
	@JoinColumn(name = "fkRegras", referencedColumnName = "idRegras")
	private RegrasUsuario regrasUsuario;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * @return the regrasUsuario
	 */
	public RegrasUsuario getRegrasUsuario() {
		return regrasUsuario;
	}

	/**
	 * @param regrasUsuario the regrasUsuario to set
	 */
	public void setRegrasUsuario(RegrasUsuario regrasUsuario) {
		this.regrasUsuario = regrasUsuario;
	}

}