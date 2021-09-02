package com.ipartek.formacion.uf2177repaso.presentacion;

import com.ipartek.formacion.uf2177repaso.accesodatos.Dao;
import com.ipartek.formacion.uf2177repaso.accesodatos.DaoMueble;
import com.ipartek.formacion.uf2177repaso.entidades.Mueble;

public class Consola {
	public static void main(String[] args) {
		Dao<Mueble> dao = new DaoMueble();
		
		for(Mueble mueble: dao.obtenerTodos()) {
			System.out.println(mueble);
		}
		
		System.out.println(dao.obtenerPorId(2L));
	}
}
