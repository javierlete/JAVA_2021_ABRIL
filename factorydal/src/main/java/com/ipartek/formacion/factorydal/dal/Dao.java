package com.ipartek.formacion.factorydal.dal;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new DaoException("No implementado");
	}

	default T obtenerPorId(long id) {
		throw new DaoException("No implementado");
	}

	default T insertar(T objeto) {
		throw new DaoException("No implementado");
	}

	default T modificar(T objeto) {
		throw new DaoException("No implementado");
	}

	default void borrar(T objeto) {
		throw new DaoException("No implementado");
	}
}
