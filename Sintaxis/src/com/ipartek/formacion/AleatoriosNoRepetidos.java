package com.ipartek.formacion;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AleatoriosNoRepetidos {

	public static void main1(String[] args) {
		Set<Integer> comprobacion = new HashSet<Integer>();
		Integer[] numeros = new Integer[5];

		Integer aleatorio;

		for (int i = 0; i < 5; i++) {
			do {
				aleatorio = new Random().nextInt(5) + 1;
				System.out.print(aleatorio);
			} while (comprobacion.contains(aleatorio));

			comprobacion.add(aleatorio);
			numeros[i] = aleatorio;
		}

		System.out.println();

		for (Integer numero : comprobacion) {
			System.out.print(numero);
		}

		System.out.println();

		for (Integer numero : numeros) {
			System.out.print(numero);
		}
	}

	private static Integer[] numeros = new Integer[5];

	public static void main2(String[] args) {

		Integer aleatorio;

		for (int i = 0; i < 5; i++) {
			do {
				aleatorio = new Random().nextInt(5) + 1;
				System.out.print(aleatorio);
			} while (comprobarAleatorio(aleatorio));

			numeros[i] = aleatorio;
		}

		System.out.println();

		for (Integer numero : numeros) {
			System.out.print(numero);
		}
	}

	private static boolean comprobarAleatorio(Integer aleatorio) {
		for (Integer numero : numeros) {
			if (aleatorio == numero) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		Integer aleatorio;

		for (int i = 0; i < 5; i++) {
			do {
				aleatorio = new Random().nextInt(5) + 1;
				System.out.print(aleatorio);
			} while (comprobarAleatorio(aleatorio, i));

			numeros[i] = aleatorio;
		}

		System.out.println();

		for (Integer numero : numeros) {
			System.out.print(numero);
		}
	}

	private static boolean comprobarAleatorio(Integer aleatorio, int posicion) {
		for (int i = 0; i < posicion; i++) {
			if (aleatorio == numeros[i]) {
				return true;
			}
		}

		return false;
	}
}
