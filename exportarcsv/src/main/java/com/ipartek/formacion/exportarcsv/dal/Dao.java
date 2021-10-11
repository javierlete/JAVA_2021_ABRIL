package com.ipartek.formacion.exportarcsv.dal;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new DalException("No implementado");
	}
	default T obtenerPorId(long id) {
		throw new DalException("No implementado");
	}
	
	default T insertar(T objeto) {
		throw new DalException("No implementado");
	}
	default T modificar(T objeto) {
		throw new DalException("No implementado");
	}
	default T borrar(T objeto) {
		throw new DalException("No implementado");
	}
}
