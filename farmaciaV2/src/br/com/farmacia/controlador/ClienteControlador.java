package br.com.farmacia.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

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
	private void init(){
		this.clienteList = clienteServico.listar();
		cliente = new Cliente();
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
