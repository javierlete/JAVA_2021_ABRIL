package com.ipartek.formacion.poo.entidades;

import java.util.ArrayList;

public class Oficina {
	private Long id;
	private String nombre;
	private ArrayList<Persona> personas = new ArrayList<>();

	public Oficina(Long id, String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void agregar(Persona persona) {
		if (persona == null) {
			throw new RuntimeException("No se admiten personas nulas");
		}
		
		personas.add(persona);
	}

	@Override
	public String toString() {
		return "Oficina [id=" + id + ", nombre=" + nombre + ", personas=" + personas + "]";
	}
}
