package com.ipartek.formacion.mf0226spring.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ResenaCodigos {
	private Integer alumnoCodigo;
	private Integer cursoCodigo;
	private String texto;
}
