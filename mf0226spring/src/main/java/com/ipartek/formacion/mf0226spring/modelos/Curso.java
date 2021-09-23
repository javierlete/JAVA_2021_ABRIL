package com.ipartek.formacion.mf0226spring.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Curso {
	private Integer codigo;
	private String nombre;
	private String identificador;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int numeroHoras;
	private String temario;
	private boolean activo;
	private BigDecimal precio;
	
	private Profesor profesor;
	
	private Iterable<Resena> resenas;

	public Curso(Integer codigo, String nombre, String identificador, LocalDate fechaInicio, LocalDate fechaFin,
			int numeroHoras, String temario, boolean activo, BigDecimal precio, Profesor profesor) {
		this(codigo, nombre, identificador, fechaInicio, fechaFin, numeroHoras, temario, activo, precio, profesor, null);
	}
}
