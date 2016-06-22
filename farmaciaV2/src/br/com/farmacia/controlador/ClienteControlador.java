package br.com.farmacia.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.farmacia.constantes.MsgConstantes;
import br.com.farmacia.entidades.Cliente;
import br.com.farmacia.servicos.ClienteServico;

@ManagedBean
public class ClienteControlador extends CoreControlador {

	private static final long serialVersionUID = -5526946400684258997L;

	@Inject
	private ClienteServico clienteServico;
	private List<Cliente> clienteList;
	private Cliente cliente;

	@PostConstruct
	public void init() {
		listarCliente();
		cliente = new Cliente();
	}

	private void listarCliente() {
		this.clienteList = clienteServico.listar();
	}

	public void salvar() {
		clienteServico.salvar(this.cliente);
		listarCliente();
		adicionarMensagem(MsgConstantes.MSG_SUCESSO);
	}

	public void novoCliente() {
		this.cliente = new Cliente();
	}

	public void excluirCliente(Cliente cliente) {
		clienteServico.excluir(cliente);
		listarCliente();
		adicionarMensagem(MsgConstantes.MSG_SUCESSO);
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
