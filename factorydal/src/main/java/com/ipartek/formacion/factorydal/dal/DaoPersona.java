package com.ipartek.formacion.factorydal.dal;

import com.ipartek.formacion.factorydal.entidades.Persona;

public interface DaoPersona extends Dao<Persona> {
	default Iterable<Persona> obtenerMayoresDeEdad() {
		throw new DaoException("No implementado");
	}
}
