package com.ipartek.formacion;

import java.util.Scanner;

public class LeerNumero {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			boolean correcto = false;
			String linea;
			int numero = 0;
			
			do {
				try {
					System.out.print("Introduce un n�mero: ");
					linea = scanner.nextLine();
					
					numero = Integer.parseInt(linea);
					
					correcto = true;
				} catch (NumberFormatException e) {
					System.out.println("No me has introducido un n�mero");
				}
			} while(!correcto);
			
			System.out.println("El n�mero elegido es " + numero);
		}
	}
}
