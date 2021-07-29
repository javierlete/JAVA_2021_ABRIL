package com.ipartek.formacion.uf2175spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.uf2175spring.accesodatos.Dao;
import com.ipartek.formacion.uf2175spring.entidades.Persona;

@SpringBootApplication
public class Uf2175springApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Uf2175springApplication.class, args);
	}

	@Autowired
	private Dao<Persona> dao;
	
	@Override
	public void run(String... args) throws Exception {
		// Dao<Persona> dao = new PersonaDao();

		dao.insertar(new Persona(null, "NUEVO", "NUEVEZ"));
		dao.modificar(new Persona(3L, "MODIFICADO", "MODIFICADEZ"));
		dao.borrar(5L);

		for (Persona persona : dao.obtenerTodos()) {
			System.out.println(persona);
		}

		System.out.println(dao.obtenerPorId(4L));
	}

}
