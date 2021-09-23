package com.ipartek.formacion.mf0226spring.accesodatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.mf0226spring.modelos.ResenaCodigos;

@Repository
public class DaoMySqlResena implements Dao<ResenaCodigos> {

	@Autowired
	private JdbcTemplate jdbc;

	private static final String SQL_INSERT = "INSERT INTO resenas (alumno_codigo, curso_codigo, texto) VALUES (?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE resenas SET texto = ? WHERE alumno_codigo = ? AND curso_codigo = ?";
	private static final String SQL_DELETE = "DELETE FROM resenas WHERE alumno_codigo = ? AND curso_codigo = ?";

	@Override
	public ResenaCodigos insertar(ResenaCodigos resena) {
		jdbc.update(SQL_INSERT, resena.getAlumnoCodigo(), resena.getCursoCodigo(), resena.getTexto());

		return resena;
	}

	@Override
	public ResenaCodigos modificar(ResenaCodigos resena) {
		jdbc.update(SQL_UPDATE, resena.getTexto(), resena.getAlumnoCodigo(), resena.getCursoCodigo());

		return resena;
	}

	@Override
	public void borrar(ResenaCodigos resena) {
		jdbc.update(SQL_DELETE, resena.getAlumnoCodigo(), resena.getCursoCodigo());
	}

}
