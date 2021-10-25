package com.ipartek.formacion.factorydalspring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.formacion.factorydalspring.entidades.Persona;

/*
 * Dao -> (CrudRepository -> PagingAndSortingRepository -> JpaRepository)
 * DaoException -> DataAccessException
 * DaoMySqlPersona -> Este interface se autoimplementa en Spring creando la clase por sí sólo
 * DaoPersona -> PersonaRepository
 * FabricaDao -> SPRING (Repository)
 * FabricaDaoImpl -> SPRING (@Autowired)
 */

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	// Iterable<Persona> findByEdadGreatherThan18();
	Iterable<Persona> findByNombre(String nombre);
}
