package com.ipartek.formacion.mf0226spring.controladores;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.mf0226spring.accesodatos.Dao;
import com.ipartek.formacion.mf0226spring.modelos.Curso;
import com.ipartek.formacion.mf0226spring.modelos.ResenaCodigos;

@RestController
@RequestMapping("/api")
public class GestionDocenteRestController {

	private static Logger LOGGER = Logger.getLogger(GestionDocenteRestController.class.getName());
	
	@Autowired
	private Dao<Curso> daoCurso;
	@Autowired
	private Dao<ResenaCodigos> daoResena;
	
	@GetMapping("/cursos")
	public Iterable<Curso> getCursos() {
		Iterable<Curso> cursos = daoCurso.obtenerTodos();
		LOGGER.info(cursos.toString());
		return cursos;
	}
	
	@GetMapping("/cursos/{id}")
	public Curso getCurso(@PathVariable int id) {
		Curso curso = daoCurso.obtenerPorId(id);
		LOGGER.info(curso.toString());
		return curso;
	}
	
	@PostMapping("/resenas")
	public ResenaCodigos postResena(@RequestBody ResenaCodigos resena) {
		LOGGER.info(resena.toString());
		return daoResena.insertar(resena);
	}
	
	@PutMapping("/resenas/{id}")
	public ResenaCodigos putResena(@RequestBody ResenaCodigos resena) {
		LOGGER.info(resena.toString());
		return daoResena.modificar(resena);
	}
	
	@DeleteMapping("/resenas/{id}")
	public void deleteResena(@RequestBody ResenaCodigos resena) {
		LOGGER.info(resena.toString());
		daoResena.borrar(resena);
	}
}
