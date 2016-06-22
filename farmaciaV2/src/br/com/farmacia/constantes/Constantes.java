package br.com.farmacia.constantes;

import java.math.BigDecimal;

public abstract class Constantes {

	private Constantes() {
		
	}

	public static final String PONTO_E_VIRGULA = ";";
	public static final String ESPACO_EM_BRANCO = " ";
	public static final String STRING_VAZIA = "";

	/* TAG HTML */

	public static final String TAG_BR = "<br />";

	/* PAGINAS */

	public static final String PAGINA_LISTAR_CLIENTES = "listarClientes";
	public static final String PAGINA_CLIENTE = "cliente";
	public static final String PAGINA_LISTAR_PRODUTOS = "listarProdutos";
	public static final String PAGINA_PRODUTO = "produto";
	public static final Long ID_JOAO_PESSOA = 4964L;
	public static final String PAGINA_LISTAR_PEDIDOS = "listarPedidos";
	public static final String PAGINA_PEDIDO = "pedido";
	public static final BigDecimal ZERO = new BigDecimal(0);
	public static final String ERRO_NA_EXECUÇÃO_DO_MÉTODO_ASSÍCRONO = " Erro na execução do método assícrono ";
}
