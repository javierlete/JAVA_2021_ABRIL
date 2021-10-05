package com.ipartek.formacion.seguridadservlets.daos;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new DaosException("No está implementado el método");
	}

	default T obtenerPorId(long id) {
		throw new DaosException("No está implementado el método");
	}

	default T insertar(T objeto) {
		throw new DaosException("No está implementado el método");
	}

	default T modificar(T objeto) {
		throw new DaosException("No está implementado el método");
	}

	default void borrar(long id) {
		throw new DaosException("No está implementado el método");
	}
}
