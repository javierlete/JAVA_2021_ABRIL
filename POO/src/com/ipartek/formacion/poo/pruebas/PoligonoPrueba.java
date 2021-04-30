package com.ipartek.formacion.poo.pruebas;

import com.ipartek.formacion.poo.entidades.Poligono;
import com.ipartek.formacion.poo.entidades.Punto;
import com.ipartek.formacion.poo.entidades.PuntoNombre;

public class PoligonoPrueba {

	public static void main(String[] args) {
		Poligono p = new Poligono();
		
		p.agregar(new Punto(1,2));
		p.agregar(new PuntoNombre(10, 20, "Bilbao"));
		
		for(Punto punto: p.getPuntos()) {
			System.out.println(punto);
		}
	}

}
