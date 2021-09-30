package com.ipartek.formacion.springdatarelaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.springdatarelaciones.entidades.Rol;
import com.ipartek.formacion.springdatarelaciones.entidades.Usuario;
import com.ipartek.formacion.springdatarelaciones.repositorios.RolRepository;
import com.ipartek.formacion.springdatarelaciones.repositorios.UsuarioRepository;

@SpringBootApplication
public class SpringdatarelacionesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatarelacionesApplication.class, args);
	}

	@Autowired
	private RolRepository rolRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public void run(String... args) throws Exception {
		rolRepo.save(new Rol(null, "ADMIN", null));
		rolRepo.save(new Rol(null, "USER", null));
		
		Rol rolAdmin = rolRepo.findByNombre("ADMIN");
		Rol rolUser = rolRepo.findByNombre("USER");
		
		Usuario javier = new Usuario(null, "Javier", "javier@email.net", "contra", rolAdmin);
		Usuario admin = new Usuario(null, "Administrador", "admin@email.net", "admin", rolAdmin);
		Usuario pepe = new Usuario(null, "Pepe", "pepe@email.net", "pepe", rolUser);
		
		usuarioRepo.save(javier);
		usuarioRepo.save(admin);
		usuarioRepo.save(pepe);
		
		List<Usuario> administradores = rolRepo.findByNombreConUsuarios("ADMIN").getUsuarios();
		
		for(Usuario usuario: administradores) {
			System.out.println(usuario);
		}
		
		Usuario buscado = usuarioRepo.findByEmail("pepe@email.net");
		
		System.out.println(buscado);
	}

}
