package com.ipartek.formacion.poo.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.poo.entidades.Empleado;
import com.ipartek.formacion.poo.entidades.Persona;

public class EmpleadoPrueba {
	public static void main(String[] args) {
		Empleado e = new Empleado("Pepe", 2003, 4, 20, "12938476192");

		System.out.println(e);

		e.setId(1L);
		e.setNombre("   Javier  ");
		e.setFechaNacimiento(1980, 1, 2);
		e.setNss("123456781234985123984");

		System.out.println(e);
//		System.out.println(e.getNss());
		
		Persona p = e;
		
		// System.out.println(p.getNss());
		
		//p.setFechaNacimiento(LocalDate.of(2010, 1, 1));
		
		System.out.println(p);
		
		Empleado e2 = (Empleado) p;
		
		System.out.println(e2);
		
		Persona p2 = new Persona();
		
		p2.setFechaNacimiento(LocalDate.of(2010, 1, 1));
		
		System.out.println(p2);
		
		Object o = e;
		
		System.out.println(o);
		
		System.out.println(p.getClass().getName());
		
		System.out.println(p.hashCode());

		System.out.println(new Persona() == new Persona()); 		// Si son la misma
		System.out.println(new Persona().equals(new Persona()));	// Si son gemelas
	}
}
