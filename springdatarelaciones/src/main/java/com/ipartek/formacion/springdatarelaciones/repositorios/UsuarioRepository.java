package com.ipartek.formacion.springdatarelaciones.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.springdatarelaciones.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Usuario findByNombre(String nombre);
	Usuario findByEmail(String email);
	Usuario findByEmailAndPassword(String email, String password);
}
