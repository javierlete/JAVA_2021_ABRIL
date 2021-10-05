package com.ipartek.formacion.seguridadservlets.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
	private Long id;
	private String nombre;
}
