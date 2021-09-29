package com.ipartek.formacion.springdata.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.springdata.entidades.Persona;

@RepositoryRestResource(collectionResourceRel = "personas", path = "personas")
public interface PersonaRepository extends CrudRepository<Persona, Long> {
	Persona findByNombre(String nombre);
}
