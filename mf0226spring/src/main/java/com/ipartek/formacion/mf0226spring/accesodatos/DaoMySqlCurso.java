package com.ipartek.formacion.mf0226spring.accesodatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.mf0226spring.modelos.Alumno;
import com.ipartek.formacion.mf0226spring.modelos.Curso;
import com.ipartek.formacion.mf0226spring.modelos.Profesor;
import com.ipartek.formacion.mf0226spring.modelos.Resena;

@Repository
public class DaoMySqlCurso implements Dao<Curso> {

	@Autowired
	private JdbcTemplate jdbc;

	private static final String SQL_SELECT = "SELECT * FROM curso c JOIN profesor p ON c.profesor_codigo = p.codigo";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE c.codigo = ?";
	private static final String SQL_SELECT_RESENAS = "SELECT \r\n"
			+ "    r.texto AS texto, a.codigo AS codigo, a.nombre AS nombre, a.apellidos AS apellidos\r\n" + "FROM\r\n"
			+ "    resenas r\r\n" + "        JOIN\r\n" + "    alumno a ON r.alumno_codigo = a.codigo\r\n" + "WHERE\r\n"
			+ "    curso_codigo = ?;";

	@Override
	public Iterable<Curso> obtenerTodos() {
		return jdbc.query(SQL_SELECT, (rs, rowNum) -> {
			Profesor profesor = new Profesor(rs.getInt("p.codigo"), rs.getString("p.nombre"),
					rs.getString("p.apellidos"));
			Curso curso = new Curso((Integer) rs.getObject("c.codigo"), rs.getString("c.nombre"),
					rs.getString("c.identificador"), rs.getDate("c.fInicio").toLocalDate(),
					rs.getDate("c.fFin").toLocalDate(), rs.getInt("c.nHoras"), rs.getString("c.temario"),
					rs.getBoolean("c.activo"), rs.getBigDecimal("c.precio"), profesor);
			return curso;
		});
	}

	@Override
	public Curso obtenerPorId(Integer id) {
		Curso curso = (Curso) jdbc.queryForObject(SQL_SELECT_ID, (rs, rowNum) -> {
			Profesor profesor = new Profesor(rs.getInt("p.codigo"), rs.getString("p.nombre"),
					rs.getString("p.apellidos"));
			Curso c = new Curso((Integer) rs.getObject("c.codigo"), rs.getString("c.nombre"),
					rs.getString("c.identificador"), rs.getDate("c.fInicio").toLocalDate(),
					rs.getDate("c.fFin").toLocalDate(), rs.getInt("c.nHoras"), rs.getString("c.temario"),
					rs.getBoolean("c.activo"), rs.getBigDecimal("c.precio"), profesor);
			return c;
		}, id);

		if (curso != null) {
			Iterable<Resena> resenas = jdbc.query(SQL_SELECT_RESENAS, (rs, rowNum) -> {
				Alumno alumno = new Alumno(rs.getInt("codigo"), rs.getString("nombre"), rs.getString("apellidos"));
				Resena resena = new Resena(alumno, null, rs.getString("texto"));
				return resena;
			}, id);
			curso.setResenas(resenas);
		}

		return curso;
	}
}
