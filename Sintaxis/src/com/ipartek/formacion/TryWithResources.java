package com.ipartek.formacion;

import java.util.Scanner;

public class TryWithResources {
	public static void main(String[] args) {
		// Java 7 o superior
		try(Scanner scanner = new Scanner(System.in)) {
			// Código que utiliza scanner
		} // Al cerrar la llave del try se cierra automáticamente el Scanner pase lo que pase
	}

	public static void mainAntiguo(String[] args) {
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(System.in);
			
			// Código que utiliza scanner
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
