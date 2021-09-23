package com.ipartek.formacion.mf0226spring.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Alumno {
	private Integer codigo;
	private String nombre;
	private String apellidos;
}
