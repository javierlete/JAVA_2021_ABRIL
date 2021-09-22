package com.ipartek.formacion.mf0226spring.controladores;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.mf0226spring.accesodatos.Dao;
import com.ipartek.formacion.mf0226spring.modelos.Curso;
import com.ipartek.formacion.mf0226spring.modelos.Profesor;

@RestController
@RequestMapping("/api")
public class GestionDocenteRestController {

	private static Logger LOGGER = Logger.getLogger(GestionDocenteRestController.class.getName());
	
	@Autowired
	private Dao<Curso> daoCurso;
	
	@GetMapping("/cursos")
	public Iterable<Curso> getCursos() {
		Iterable<Curso> cursos = daoCurso.obtenerTodos();
		LOGGER.info(cursos.toString());
		return cursos;
	}
}
