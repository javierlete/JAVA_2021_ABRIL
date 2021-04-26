package com.ipartek.formacion.mf0227.uf2404.ejercicio1;

import java.util.Scanner;

/*
 * B) Crear un proyecto en modo consola que nos muestre un menú de 3 opciones
 * Calcular la letra del dni Calcular medida de cm a pulgadas Salir Hacer que
 * dicho menú se ejecute en bucle hasta que se pulse salir, y si el usuario
 * escoge cada una de las funciones, que permita introducir los datos
 * correspondientes por teclado para poder dar el resultado
 */
public class ApartadoB {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int opcion;

		do {
			System.out.println("1. Calcular letra DNI");
			System.out.println("2. Calcular medida de cm a pulgadas");
			System.out.println("3. Salir");

			opcion = s.nextInt();
			s.nextLine();

			switch (opcion) {
			case 1:
				System.out.print("Dame el número del DNI: ");
				int numero = s.nextInt();

				String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
				int resto = numero % 23;
				char letra = letras.charAt(resto);

				System.out.println(String.valueOf(numero) + letra);
				break;
			case 2:
				System.out.print("Dime los cms: ");
				double cm = s.nextDouble();

				double pulgadas = cm / 2.54;

				System.out.println(pulgadas);
				break;
			case 3:
				System.out.println("Gracias por su visita");
				break;
			default:
				System.out.println("No existe esa opción");
			}
		} while (opcion != 3);

		s.close();
	}
}
