package com.ipartek.formacion.springdata.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.springdata.entidades.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
	Persona findByNombre(String nombre);
}
