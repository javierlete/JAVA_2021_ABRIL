package com.ipartek.formacion.poo.pruebas;

import static com.ipartek.formacion.bibliotecas.Consola.leerBoolean;
import static com.ipartek.formacion.bibliotecas.Consola.leerLocalDate;
import static com.ipartek.formacion.bibliotecas.Consola.leerLong;
import static com.ipartek.formacion.bibliotecas.Consola.leerString;
import static com.ipartek.formacion.bibliotecas.Consola.pl;

import java.util.ArrayList;

import com.ipartek.formacion.poo.entidades.Persona;

public class PooPrueba {

	public static void main(String[] args) {
		boolean seguir = false;

		Persona persona;
		
//		Oficina oficina = new Oficina(1L, "Bilbao");
		
		ArrayList<Persona> personas = new ArrayList<>();
		
		do {
			persona = new Persona();
			
			persona.setId(leerLong("Dime el ID"));
			persona.setNombre(leerString("Dime el nombre"));
			persona.setFechaNacimiento(leerLocalDate("Dime tu fecha de nacimiento"));

			personas.add(persona);
			
//			oficina.agregar(persona);
			
			seguir = leerBoolean("¿Quieres introducir otra persona?");
		} while (seguir);

		for(Persona p: personas) {
			pl(p);
		}
		
//		for(Persona p: oficina.getPersonas()) {
//			pl(p);
//		}
	}

}
