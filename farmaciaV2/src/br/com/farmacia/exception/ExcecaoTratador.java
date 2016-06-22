package br.com.farmacia.exception;

public class ExcecaoTratador {

	public static void tratar(Throwable t) {
		t.printStackTrace();
	}

	public static void tratar(String excecao) {
		System.err.println(excecao);
	}
}
