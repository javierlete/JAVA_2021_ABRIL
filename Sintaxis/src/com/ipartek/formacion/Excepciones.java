package com.ipartek.formacion;

import java.util.Scanner;

public class Excepciones {
	public static void main(String[] args) {
		int div = 0, a = 6;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Antes");

		try {
			int[] arr = new int[2];

			arr[2] = 5;

			System.out.print("Introduce un n�mero: ");
			String linea = scanner.nextLine();

			int numero = Integer.parseInt(linea);

			div = a / numero;
		} catch (ArithmeticException ae) {
			System.out.println("Se ha detectado una divisi�n por cero");
			System.out.println("Asumimos el m�ximo valor en la divisi�n");
			div = Integer.MAX_VALUE;
		} catch (NumberFormatException nfe) {
			System.out.println("El n�mero no era v�lido");
		} catch (Exception e) {
			System.out.println("Error no esperado");
			System.out.println(e.getMessage());

			// System.exit(1);
			return;
		} finally {
			System.out.println("Cierro el esc�ner");
			scanner.close();
		}

		System.out.println(div);

		System.out.println("Despu�s");
	}
}
