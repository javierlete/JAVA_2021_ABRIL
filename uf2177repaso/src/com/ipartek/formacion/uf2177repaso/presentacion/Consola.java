package com.ipartek.formacion.uf2177repaso.presentacion;

import com.ipartek.formacion.uf2177repaso.accesodatos.Dao;
import com.ipartek.formacion.uf2177repaso.accesodatos.DaoMueble;
import com.ipartek.formacion.uf2177repaso.entidades.Mueble;

public class Consola {
	public static void main(String[] args) {
		Dao<Mueble> dao = new DaoMueble();
		
		// dao.borrar(1L);
		
		System.out.println(dao.insertar(new Mueble("Prueba")));
		
		for(Mueble mueble: dao.obtenerTodos()) {
			System.out.println(mueble);
		}
		
		dao.modificar(new Mueble(2L, "Mueble modificado", 5.0, 6.0, 7.0));
		
		System.out.println(dao.obtenerPorId(2L));
	}
}
