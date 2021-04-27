package com.ipartek.formacion.bibliotecas;

import static com.ipartek.formacion.bibliotecas.Consola.*;

public class ConsolaPrueba {

	public static void main(String[] args) {
		p("Hola, ");
		pl("qué tal");
		pl("Hola a todos");
		
		String nombre = leerString("Dime tu nombre");
		int edad = leerInt("Dime tu edad");
		boolean suscriptor = leerBoolean("¿Quieres suscribirte?");
		
		pl(nombre);
		pl(edad);
		pl(suscriptor);
	}

}
