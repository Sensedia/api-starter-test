package com.sensedia.test.infra;

public class BuilderUtils {

	/**
	 * @param length - tamanho da string a ser gerada.
	 * @return - uma string com o tamanho informado.
	 */
	public static String generateString(int length) {

		StringBuilder str = new StringBuilder();

		for (int i = 0; i < length; i++) {
			str.append("X");
		}

		return str.toString();

	}

}
