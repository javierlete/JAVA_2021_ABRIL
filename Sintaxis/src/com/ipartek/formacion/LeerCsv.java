package com.ipartek.formacion;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeerCsv {

	public static void main(String[] args) {
		try (FileReader fr = new FileReader("datos.csv");
				Scanner s = new Scanner(fr)) {
			String linea;
			String[] campos;
			
			int id;
			String nombre;
			String apellidos;
			
			s.nextLine();
			
			while(s.hasNextLine()) {
				linea = s.nextLine();
				
				campos = linea.split(";");
				
				id = Integer.parseInt(campos[0]);
				nombre = campos[1];
				apellidos = campos[2];
				
				System.out.printf("%s: %s %s\n", id, nombre, apellidos);
				
//			for(String campo: campos) {
//				System.out.println(campo);
//			}
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Error al leer el CSV");
			System.out.println(e.getMessage());
		}
	}
}
