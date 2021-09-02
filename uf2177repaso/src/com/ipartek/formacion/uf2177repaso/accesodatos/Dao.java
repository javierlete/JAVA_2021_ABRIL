package com.ipartek.formacion.uf2177repaso.accesodatos;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("M�todo no implementado");
	}
	
	default T obtenerPorId(Long id){
		throw new AccesoDatosException("M�todo no implementado");
	}
	
	default T insertar(T objeto){
		throw new AccesoDatosException("M�todo no implementado");
	}
	
	default T modificar(T objeto){
		throw new AccesoDatosException("M�todo no implementado");
	}
	
	default void borrar(Long id){
		throw new AccesoDatosException("M�todo no implementado");
	}
}
