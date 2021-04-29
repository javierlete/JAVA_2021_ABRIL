package com.ipartek.formacion.poo.pruebas;

import com.ipartek.formacion.poo.entidades.Punto;

public class PuntoPrueba {

	public static void main(String[] args) {
		Punto p = new Punto(1, 2);
		Punto p2 = new Punto(5, 2);

		p.setX(5);

		System.out.println(p);

		System.out.println(p.getX());

		System.out.println(p.equals(p2));

		Punto p3 = new Punto(23, 2);
		
		System.out.println(p3);
	}

}
