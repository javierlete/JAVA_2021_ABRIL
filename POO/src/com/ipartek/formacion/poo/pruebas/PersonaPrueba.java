package com.ipartek.formacion.poo.pruebas;

import java.time.LocalDate;

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
		} catch (Exception e) {
			System.out.println("Error no esperado");
			System.out.println(e.getMessage());
		}
	}
}
