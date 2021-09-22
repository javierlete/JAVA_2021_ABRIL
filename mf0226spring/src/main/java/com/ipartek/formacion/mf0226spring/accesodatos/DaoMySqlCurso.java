package com.ipartek.formacion.mf0226spring.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.mf0226spring.modelos.Alumno;
import com.ipartek.formacion.mf0226spring.modelos.Curso;
import com.ipartek.formacion.mf0226spring.modelos.Profesor;
import com.ipartek.formacion.mf0226spring.modelos.Resena;

@Repository
public class DaoMySqlCurso implements Dao<Curso> {

	private static final String URL = "jdbc:mysql://localhost:3306/gestiondocente";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "admin";
	private static final String SQL_SELECT = "SELECT * FROM curso c JOIN profesor p ON c.profesor_codigo = p.codigo";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE c.codigo = ?";
	private static final String SQL_SELECT_RESENAS = "SELECT \r\n"
			+ "    r.texto AS texto, a.codigo AS codigo, a.nombre AS nombre, a.apellidos AS apellidos\r\n"
			+ "FROM\r\n"
			+ "    resenas r\r\n"
			+ "        JOIN\r\n"
			+ "    alumno a ON r.alumno_codigo = a.codigo\r\n"
			+ "WHERE\r\n"
			+ "    curso_codigo = ?;";
	
	@Override
	public Iterable<Curso> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_SELECT);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<Curso> cursos = new ArrayList<Curso>();
			Profesor profesor;
			
			while(rs.next()) {
				profesor = new Profesor(rs.getInt("p.codigo"), rs.getString("p.nombre"), rs.getString("p.apellidos"));
				cursos.add(new Curso((Integer)rs.getObject("c.codigo"), rs.getString("c.nombre"), rs.getString("c.identificador"), rs.getDate("c.fInicio").toLocalDate(), rs.getDate("c.fFin").toLocalDate(), rs.getInt("c.nHoras"), rs.getString("c.temario"), rs.getBoolean("c.activo"), rs.getBigDecimal("c.precio"), profesor));
			}
			
			return cursos;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener los cursos", e);
		}
	}

	@Override
	public Curso obtenerPorId(Integer id) {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
				) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Curso curso = null;
			Profesor profesor;
			
			if(rs.next()) {
				profesor = new Profesor(rs.getInt("p.codigo"), rs.getString("p.nombre"), rs.getString("p.apellidos"));
				curso = new Curso((Integer)rs.getObject("c.codigo"), rs.getString("c.nombre"), rs.getString("c.identificador"), rs.getDate("c.fInicio").toLocalDate(), rs.getDate("c.fFin").toLocalDate(), rs.getInt("c.nHoras"), rs.getString("c.temario"), rs.getBoolean("c.activo"), rs.getBigDecimal("c.precio"), profesor);
				
				PreparedStatement psResenas = con.prepareStatement(SQL_SELECT_RESENAS);
				psResenas.setInt(1, id);
				
				ResultSet rsResenas = psResenas.executeQuery();
				
				ArrayList<Resena> resenas = new ArrayList<>();
				Resena resena = null;
				Alumno alumno = null;
				
				while(rsResenas.next()) {
					alumno = new Alumno(rsResenas.getInt("codigo"), rsResenas.getString("nombre"), rsResenas.getString("apellidos"));
					resena = new Resena(alumno, null, rsResenas.getString("texto"));
					
					resenas.add(resena);
				}
				
				curso.setResenas(resenas);
			}
			
			return curso;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener el curso " + id, e);
		}
	}
}
