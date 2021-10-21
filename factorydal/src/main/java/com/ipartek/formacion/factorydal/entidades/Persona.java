package com.ipartek.formacion.factorydal.entidades;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Persona {
	private Long id;
	private String nombre;
	private LocalDate fechaNacimiento;
}
