package com.ipartek.formacion.poo.entidades;

import java.util.ArrayList;

public class Poligono {
	private ArrayList<Punto> puntos = new ArrayList<>();
	
	public void agregar(Punto punto) {
		puntos.add(punto);
	}
	
	public ArrayList<Punto> getPuntos() {
		return puntos;
	}
}
