package br.com.farmacia.servicos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.farmacia.constantes.Constantes;
import br.com.farmacia.constantes.MsgConstantes;
import br.com.farmacia.entidades.Usuario;
import br.com.farmacia.exception.FarmaciaException;
import br.com.farmacia.repositorio.UsuarioRepositorio;

public class UsuarioServico implements Serializable {

	private static final long serialVersionUID = 2899387627659814092L;

	@Inject
	private UsuarioRepositorio usuarioRepositorio;

//	public List<Usuario> listar() {
//		return usuarioRepositorio.listar();
//	}
//
//	public void salvar(Usuario usuario) {
////		validarSalvar(usuario);
//		usuarioRepositorio.salvar(usuario);
//
//	}

//	private void validarSalvar(Usuario usuario) {
//		camposObrigatorios(usuario);
//		usuario.setNome(removerEspacosDuplicados(usuario.getNome()));
//		verifiacarSeLoginDuplicado(usuario);
//		criptografarSenhar(usuario);
//	}
//
//	private void verifiacarSeLoginDuplicado(Usuario usuario) {
//		Usuario usuarioBD = usuarioRepositorio.consultarUsuarioPorNome(usuario.getNome());
//		if (isUsuarioValido(usuarioBD)) {
//			throw new FarmaciaExecption(MsgConstantes.LOGIN_DUPLICADO);
//		}
//	}
//
//	private String removerEspacosDuplicados(String palavra) {
//		if (palavra != null && !palavra.isEmpty()) {
//			return palavra.trim().toLowerCase().replaceAll("\\s+ ", " ");
//		}
//		return palavra;
//
//	}
//
//	private void criptografarSenhar(Usuario usuario) {
//		usuario.setSenha(new DefaultPasswordService().encryptPassword(usuario.getSenha()));
//	}
//
//	private void camposObrigatorios(Usuario usuario) {
//
//		StringBuilder erro = new StringBuilder();
//
//		if (isUsuarioValido(usuario)) {
//
//			if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
//				erro.append("Preencher o campo Nome").append(Constantes.TAG_BR);
//			}
//
//			if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
//				erro.append("Preencher o campo Senha").append(Constantes.TAG_BR);
//			}
//
//			if (usuario.getRegrasUsuario() == null) {
//				erro.append("Preencher o campo Perfil do usuário").append(Constantes.TAG_BR);
//			}
//		}
//
//		if (!erro.toString().isEmpty()) {
//			throw new FarmaciaExecption(erro.toString());
//		}
//	}
//
//	private boolean isUsuarioValido(Usuario usuario) {
//		return usuario != null;
//	}

}