package br.com.farmacia.util;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

public abstract class MascaraUtil {
	public static final String CNPJ = "##.###.###/####-##";
	public static final String CPF = "###.###.###-##";
	public static final String TELEFONE = "(##) ####-####";
	public static final String CEP = "#####-###";

	private MascaraUtil() {
		super();
	}
	
	public static String adicionarMascara(String valor, String mascara)	throws ParseException {
		String valorTemp = valor;
		if (valorTemp != null) {
			MaskFormatter mf = new MaskFormatter(mascara);
			mf.setValueContainsLiteralCharacters(false);
			valorTemp = mf.valueToString(valorTemp);
		}
		return valorTemp;
	}

	public static String removerMascara(String valor) {
		Pattern numericos = Pattern.compile("([0-9])");
		Matcher encaixe = numericos.matcher(valor);
		StringBuilder saida = new StringBuilder();
		while (encaixe.find()) {
			saida.append(encaixe.group());
		}
		return saida.toString();
	}
}