package com.ipartek.formacion.uf2175.presentacion;

import com.ipartek.formacion.uf2175.accesodatos.PersonaDao;
import com.ipartek.formacion.uf2175.entidades.Persona;

public class Consola {

	public static void main(String[] args) {

		PersonaDao.insertar(new Persona(null, "NUEVO", "NUEVEZ"));
		PersonaDao.modificar(new Persona(3L, "MODIFICADO", "MODIFICADEZ"));
		PersonaDao.borrar(5L);
		
		for (Persona persona : PersonaDao.obtenerTodos()) {
			System.out.println(persona);
		}

		System.out.println(PersonaDao.obtenerPorId(4L));

		
	}

}
