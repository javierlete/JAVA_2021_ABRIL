package com.ipartek.formacion.poo.pruebas;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ipartek.formacion.poo.entidades.Punto;

public class LeerCsv {

	public static void main(String[] args) {
		try (FileReader fr = new FileReader("puntos.csv");
				Scanner s = new Scanner(fr)) {
			String linea;
			String[] campos;
			
			Punto punto;
			
			ArrayList<Punto> puntos = new ArrayList<>();
			
			while(s.hasNextLine()) {
				linea = s.nextLine();
				
				campos = linea.split(";");
				
				punto = new Punto();
				
				punto.setX(Integer.parseInt(campos[0]));
				punto.setY(Integer.parseInt(campos[1]));
				
				puntos.add(punto);
			}
			
			for(Punto p: puntos) {
				System.out.println(p);
			}
			
			int posicionAleatoria;
			
			for(int i = 0; i < puntos.size() * 2; i++) {
				posicionAleatoria = (int)(Math.random() * puntos.size());
				
				System.out.println(posicionAleatoria);
				
				punto = puntos.get(posicionAleatoria);
				puntos.remove(posicionAleatoria);
				puntos.add(punto);
			}
			
			for(Punto p: puntos) {
				System.out.println(p);
			}
			
		} catch (NumberFormatException | IOException e) {
			System.out.println("Error al leer el CSV");
			System.out.println(e.getMessage());
		}
		
		
	}
}
