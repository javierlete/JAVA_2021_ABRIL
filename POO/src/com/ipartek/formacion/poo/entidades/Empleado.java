package com.ipartek.formacion.poo.entidades;

import java.time.LocalDate;
import java.time.Period;

public class Empleado extends Persona {
	private String nss;

	public Empleado(Long id, String nombre, LocalDate fechaNacimiento, String nss) {
		super(id, nombre, fechaNacimiento);
		setNss(nss);
	}
	
	public Empleado(String nombre, LocalDate fechaNacimiento, String nss) {
		this(null, nombre, fechaNacimiento, nss);
	}

	public Empleado(String nombre, int anyo ,int mes, int dia, String nss) {
		this(null, nombre, LocalDate.of(anyo, mes, dia), nss);
	}

//	public Empleado() {
//		super();
//	}

	public String getNss() {
		return nss;
	}

	@Override
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento.isAfter(LocalDate.now().minus(Period.ofYears(18)))) {
			throw new RuntimeException("No aceptamos explotación de menores");
		}
		
		super.setFechaNacimiento(fechaNacimiento);
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	@Override
	public String toString() {
		return "Empleado [nss=" + nss + ", id=" + getId() + ", nombre=" + getNombre() + ", fechaNacimiento="
				+ getFechaNacimiento() + "]";
	}
	
//	@Override
//	public String toString() {
//		return super.toString() + getNss();
//	}

}
