package com.ipartek.formacion.seguridadservlets.daos;

import com.ipartek.formacion.seguridadservlets.entidades.Usuario;

public interface DaoUsuario extends Dao<Usuario> {
	default Usuario obtenerPorEmail(String email) {
		throw new DaosException("No está implementado el método");
	}
}
