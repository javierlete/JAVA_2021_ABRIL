package com.ipartek.formacion.mf0226spring.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Resena {
	private Alumno alumno;
	private Curso curso;
	private String texto;
}
