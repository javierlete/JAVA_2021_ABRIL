package com.ipartek.formacion;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheros {

	public static void main(String[] args) {
		try (FileWriter fw = new FileWriter("prueba.txt");
				PrintWriter pw = new PrintWriter(fw)) {
			pw.println("Hola");
			pw.println("Escribiendo en un fichero");
		} catch (IOException e) {
			System.out.println("Ha habido un error al escribir en el fichero");
			System.out.println(e.getMessage());
		}
		
		try (FileReader fr = new FileReader("prueba.txt");
				Scanner s = new Scanner(fr)) {
			String linea;
			
			while(s.hasNextLine()) {
				linea = s.nextLine();
				System.out.println(linea);
			}
		} catch (IOException e) {
			System.out.println("Ha habido un error al leer del fichero");
			System.out.println(e.getMessage());
		}
	}

}
