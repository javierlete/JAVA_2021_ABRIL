package com.ipartek.formacion.springrestjavascript.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.springrestjavascript.entidades.Persona;

@RepositoryRestResource(collectionResourceRel = "personas", path = "personas")
public interface PersonaRepository extends PagingAndSortingRepository<Persona, Long> {

}
