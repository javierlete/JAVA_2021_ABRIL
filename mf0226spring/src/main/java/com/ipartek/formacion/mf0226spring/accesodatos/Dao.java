package com.ipartek.formacion.mf0226spring.accesodatos;

public interface Dao<T> {
	public default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("No implementado");
	}

	public default T obtenerPorId(Integer id) {
		throw new AccesoDatosException("No implementado");
	}

	public default T insertar(T objeto) {
		throw new AccesoDatosException("No implementado");
	}

	public default T modificar(T objeto) {
		throw new AccesoDatosException("No implementado");
	}

	public default void borrar(T objeto) {
		throw new AccesoDatosException("No implementado");
	}
	
	public default void borrar(Integer id) {
		throw new AccesoDatosException("No implementado");
	}
}
