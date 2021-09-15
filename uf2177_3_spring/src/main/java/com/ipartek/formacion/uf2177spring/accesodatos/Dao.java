package com.ipartek.formacion.uf2177spring.accesodatos;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("No implementado");
	}

	default T obtenerPorId(long id) {
		throw new AccesoDatosException("No implementado");
	}

	default T insertar(T objeto) {
		throw new AccesoDatosException("No implementado");
	}

	default T modificar(T objeto) {
		throw new AccesoDatosException("No implementado");
	}

	default void borrar(long id) {
		throw new AccesoDatosException("No implementado");
	}
}
