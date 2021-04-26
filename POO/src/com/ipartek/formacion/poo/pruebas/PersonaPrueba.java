package com.ipartek.formacion.poo.pruebas;

import java.time.LocalDate;
import java.util.Date;

import com.ipartek.formacion.poo.entidades.Persona;

public class PersonaPrueba {

	public static void main(String[] args) {
		Persona persona;

		persona = new Persona();

		System.out.println(persona);
		System.out.println(persona.aTexto());

		try {
			persona.setId(1L);
			persona.setNombre("  Javier    ");
			persona.setFechaNacimiento(LocalDate.of(1980, 1, 1));
			
			System.out.println(persona.getId());
			System.out.println(persona.getNombre());
			System.out.println(persona.getFechaNacimiento());
			
			System.out.println(persona.aTexto());
			
			Persona p2 = new Persona("Pepe", LocalDate.of(1990, 2, 2));
			
			System.out.println(p2.getId());
			System.out.println(p2.getNombre());
			System.out.println(p2.getFechaNacimiento());
			
			System.out.println(p2.aTexto());
			
			Persona p3 = new Persona("Juan");
			
			System.out.println(p3.aTexto());
			
			Persona pe1 = new Persona(5L, "Javier", LocalDate.of(1990, 5, 5));
			Persona pe2 = new Persona(pe1);
			
			pe1.setFechaNacimiento(new Date());
			
			pe2.setNombre("Pepe");
			pe2.setFechaNacimiento(1980,1,2);
			
			System.out.println(pe1.toString());
			System.out.println(pe2);
		} catch (Exception e) {
			System.out.println("Error no esperado");
			System.out.println(e.getMessage());
		}
	}
}
