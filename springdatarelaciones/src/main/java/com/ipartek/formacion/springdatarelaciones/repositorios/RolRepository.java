package com.ipartek.formacion.springdatarelaciones.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.springdatarelaciones.entidades.Rol;

public interface RolRepository extends CrudRepository<Rol, Long> {
	Rol findByNombre(String nombre);
	@Query("select r from Rol r join fetch r.usuarios where r.nombre = ?1")
	Rol findByNombreConUsuarios(String nombre);
}
