package com.ipartek.formacion.springdata;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.springdata.entidades.Persona;
import com.ipartek.formacion.springdata.repositorios.PersonaRepository;

@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}

	@Autowired
	private PersonaRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Persona(null, "Pepe", LocalDate.now()));
		repo.save(new Persona(null, "Juan", LocalDate.now()));
		repo.save(new Persona(null, "Pedro", LocalDate.now()));

		Persona persona2 = repo.findById(2L).get();

		System.out.println(persona2);

		persona2.setNombre("Modificado2");

		repo.save(persona2);

		Persona persona3 = new Persona(3L, "Modificado3", null);

		repo.save(persona3);

		repo.deleteById(1L);

		for (Persona persona : repo.findAll()) {
			System.out.println(persona);
		}
		
		System.out.println(repo.findByNombre("Modificado2"));
	}

}
