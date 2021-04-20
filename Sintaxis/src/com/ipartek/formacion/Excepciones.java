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

			System.out.print("Introduce un número: ");
			String linea = scanner.nextLine();

			int numero = Integer.parseInt(linea);

			div = a / numero;
		} catch (ArithmeticException ae) {
			System.out.println("Se ha detectado una división por cero");
			System.out.println("Asumimos el máximo valor en la división");
			div = Integer.MAX_VALUE;
		} catch (NumberFormatException nfe) {
			System.out.println("El número no era válido");
		} catch (Exception e) {
			System.out.println("Error no esperado");
			System.out.println(e.getMessage());

			// System.exit(1);
			return;
		} finally {
			System.out.println("Cierro el escáner");
			scanner.close();
		}

		System.out.println(div);

		System.out.println("Después");
	}
}
