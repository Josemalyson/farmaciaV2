package br.com.farmacia.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.farmacia.constantes.MsgConstantes;
import br.com.farmacia.entidades.Fornecedor;
import br.com.farmacia.servicos.FornecedorServico;

@ManagedBean
public class FornecedorControlador extends CoreControlador {

	private static final long serialVersionUID = -5526946400684258997L;

	@Inject
	private FornecedorServico fornecedorServico;
	private List<Fornecedor> fornecedorList;
	private Fornecedor fornecedor;

	@PostConstruct
	public void init() {
		listarFornecedor();
		fornecedor = new Fornecedor();
	}

	private void listarFornecedor() {
		this.fornecedorList = fornecedorServico.listar();
	}

	public void salvar() {
		fornecedorServico.salvar(this.fornecedor);
		listarFornecedor();
		adicionarMensagem(MsgConstantes.MSG_SUCESSO);
	}

	public void novoFornecedor() {
		this.fornecedor = new Fornecedor();
	}

	public void excluirFornecedor(Fornecedor fonecedor) {
		fornecedorServico.excluir(fonecedor);
		listarFornecedor();
		adicionarMensagem(MsgConstantes.MSG_SUCESSO);
	}

	public List<Fornecedor> getFornecedorList() {
		return fornecedorList;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedorList(List<Fornecedor> fornecedorList) {
		this.fornecedorList = fornecedorList;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
