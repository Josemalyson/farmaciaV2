package br.com.farmacia.servicos;

import java.util.List;

import javax.inject.Inject;

import br.com.farmacia.entidades.RegrasUsuario;
import br.com.farmacia.repositorio.RegraUsuarioRepositorio;

public class RegrasUsuarioServico {

	@Inject
	private RegraUsuarioRepositorio regraUsuarioRepositorio;
	
	public List<RegrasUsuario> listar(){
		return regraUsuarioRepositorio.listar();
	}
}
