package atividade_avaliativa_01;

import java.util.ArrayList;
import java.util.List;

public class CadeiaDeCaracteres {

	public static void main(String args[]) {
		System.out.println(converterCamelCase("nome#Composto"));
		System.out.println(converterCamelCase("10Primeiros"));
		System.out.println(converterCamelCase("nome"));
		System.out.println(converterCamelCase("Nome"));
		System.out.println(converterCamelCase("nomeComposto"));
		System.out.println(converterCamelCase("NomeComposto"));
		System.out.println(converterCamelCase("CPF"));
		System.out.println(converterCamelCase("numeroCPF"));
		System.out.println(converterCamelCase("numeroCPFContribuinte"));
		System.out.println(converterCamelCase("recupera10Primeiros"));
	}

	public static Boolean cadeiaValida(String original) {
		return ((original != null) && (original.trim().length() > 0));
	}

	public static Boolean haCaracteresEspeciais(String original) {
		boolean caractereEspecial = false;

		for (int i = 0; i < original.length(); i++) {
			if (!(Character.isLetter(original.charAt(i)) || Character.isDigit(original.charAt(i)))) {
				caractereEspecial = true;
			}
		}
		return caractereEspecial;
	}

	public static Boolean iniciaComNumeros(String original) {
		return Character.isDigit(original.charAt(0));
	}

	public static List<String> converterCamelCase(String original) {
		if (haCaracteresEspeciais(original)) {
			throw new CadeiaDeCaracteresException("Caracteres especiais n�o s�o permitidos, somente letras e n�meros.");
		} else if (iniciaComNumeros(original)) {
			throw new CadeiaDeCaracteresException("N�o � permitido cadeias iniciadas com n�meros.");
		} else if (!cadeiaValida(original)) {
			throw new CadeiaDeCaracteresException("N�o h� uma cadeia de caracteres v�lida.");
		}

		String[] originalSplit = original.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])");

		return passarParaLowerCase(originalSplit);
	}

	private static List<String> passarParaLowerCase(String[] array) {
		List<String> lista = new ArrayList<String>();
		for (int i = 0; i < array.length; i++)
			if (!array[i].isEmpty())
				if (array[i].equals(array[i].toUpperCase()))
					lista.add(array[i]);
				else
					lista.add(array[i].toLowerCase());
		return lista;
	}
}
