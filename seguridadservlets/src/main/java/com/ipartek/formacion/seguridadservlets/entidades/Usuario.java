package com.ipartek.formacion.seguridadservlets.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	private Long id;
	private String email;
	private String password;
	private Rol rol;
}
