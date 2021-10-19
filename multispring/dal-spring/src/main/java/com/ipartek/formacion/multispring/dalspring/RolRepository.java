package com.ipartek.formacion.multispring.dalspring;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.multispring.entidadesspring.Rol;

@RepositoryRestResource(collectionResourceRel = "roles", path = "roles")
public interface RolRepository extends PagingAndSortingRepository<Rol, Long> {

}
