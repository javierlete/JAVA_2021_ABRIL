package com.ipartek.formacion.poo.entidades;

import java.time.LocalDate;

public class Persona {
	// Variables de instancia (fields)
	private Long id;
	private String nombre;
	private LocalDate fechaNacimiento;

	// Constructores
	public Persona(Long id, String nombre, LocalDate fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public Persona(Persona persona) {
		this(persona.getId(), persona.getNombre(), persona.getFechaNacimiento());
	}
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		this(null, nombre, fechaNacimiento);
	}

	public Persona(Long id, String nombre) {
		this(id, nombre, null);
	}
	
	public Persona(String nombre) {
		this(null, nombre, null);
	}
	
	public Persona() {
		this(null, "DESCONOCIDO", null);
	}

	// Métodos de acceso
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
		if(nombre == null) {
			throw new RuntimeException("No se admiten valores nulos");
		}
		
		if(nombre.trim().length()== 0) {
			throw new RuntimeException("No se admiten nombres sin ningún caracter");
		}
		this.nombre = nombre.trim();
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String aTexto() {
		return id + ", " + nombre + ", " + fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
}
