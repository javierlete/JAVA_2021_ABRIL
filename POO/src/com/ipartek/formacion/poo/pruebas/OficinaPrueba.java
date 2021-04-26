package com.ipartek.formacion.poo.pruebas;

import com.ipartek.formacion.poo.entidades.Oficina;
import com.ipartek.formacion.poo.entidades.Persona;

public class OficinaPrueba {

	public static void main(String[] args) {
		Oficina o = new Oficina(1L, "Bilbao");
		
		o.agregar(new Persona());
//		o.agregar(null);
		o.agregar(new Persona("    Javier   "));
		
		for(Persona p: o.getPersonas()) {
			System.out.println(p);
		}
	}
}
