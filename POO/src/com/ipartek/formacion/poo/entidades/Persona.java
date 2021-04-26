package com.ipartek.formacion.poo.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

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

	// M�todos de acceso (getters y setters)
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
		if (nombre == null) {
			throw new RuntimeException("No se admiten valores nulos");
		}

		if (nombre.trim().length() == 0) {
			throw new RuntimeException("No se admiten nombres sin ning�n caracter");
		}

		this.nombre = nombre.trim();
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	// Sobrecargas de m�todo
	public void setFechaNacimiento(int anyo, int mes, int dia) {
		setFechaNacimiento(LocalDate.of(anyo, mes, dia));
	}

	public void setFechaNacimiento(GregorianCalendar fecha) {
		setFechaNacimiento(LocalDateTime.ofInstant(fecha.toInstant(), fecha.getTimeZone().toZoneId()).toLocalDate());
//		setFechaNacimiento(LocalDate.of(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH) +1 , gc.get(Calendar.DAY_OF_MONTH)));
	}

	public void setFechaNacimiento(Date fecha) {
		setFechaNacimiento(LocalDateTime.ofInstant(fecha.toInstant(), ZoneId.systemDefault()).toLocalDate());
//		setFechaNacimiento(d.getYear() + 1900, d.getMonth() + 1, d.getDate());
	}

	public String aTexto() {
		return id + ", " + nombre + ", " + fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
}
