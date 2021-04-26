package com.ipartek.formacion.mf0227.uf2404.ejercicio1;

import java.util.Scanner;

/*
 * A) Realizar un programa en java que realice la siguiente función: 
 * Crear un array de 5 notas que almacenara en formato double.
 * Una vez creado dicho array se rellenaran dichos elementos leyéndolo desde el teclado.
 * Una vez creado el contenido, se calculara la media de las notas así como se mostraran 
 * las notas más altas y más bajas de dicho array.
 */
public class ApartadoA {

	public static void mainVersion1(String[] args) {
		Scanner s = new Scanner(System.in);

		double[] array = new double[5];

		for (int i = 0; i < array.length; i++) {
			System.out.print("Introduce un número: ");
			array[i] = s.nextInt();
		}

		s.close();
		
		double suma = 0;

		for (double dato : array) {
			suma += dato;
		}

		double media = suma / array.length;

		double alta = array[0];

		for (double dato : array) {
			if (dato > alta) {
				alta = dato;
			}
		}

		double baja = array[0];

		for (double dato : array) {
			if (dato < baja) {
				baja = dato;
			}
		}

		System.out.println(media);
		System.out.println(alta);
		System.out.println(baja);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		double[] array = new double[5];

		for (int i = 0; i < array.length; i++) {
			System.out.print("Introduce un número: ");
			array[i] = s.nextInt();
		}

		s.close();
		
		double suma = 0;
		double alta = array[0];
		double baja = array[0];

		for (double dato : array) {
			suma += dato;

			if (dato > alta) {
				alta = dato;
			}

			if (dato < baja) {
				baja = dato;
			}
		}

		double media = suma / array.length;

		System.out.println(media);
		System.out.println(alta);
		System.out.println(baja);
	}
}
