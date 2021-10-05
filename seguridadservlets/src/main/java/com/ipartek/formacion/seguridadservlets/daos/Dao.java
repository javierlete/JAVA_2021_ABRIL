package com.ipartek.formacion.seguridadservlets.daos;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new DaosException("No est� implementado el m�todo");
	}

	default T obtenerPorId(long id) {
		throw new DaosException("No est� implementado el m�todo");
	}

	default T insertar(T objeto) {
		throw new DaosException("No est� implementado el m�todo");
	}

	default T modificar(T objeto) {
		throw new DaosException("No est� implementado el m�todo");
	}

	default void borrar(long id) {
		throw new DaosException("No est� implementado el m�todo");
	}
}
