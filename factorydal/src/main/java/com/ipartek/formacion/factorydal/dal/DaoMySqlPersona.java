package com.ipartek.formacion.factorydal.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ipartek.formacion.factorydal.entidades.Persona;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class DaoMySqlPersona implements DaoPersona {
	private String url;
	private String usuario;
	private String password;

	private static final String SQL_SELECT = "SELECT * FROM personas";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DaoException("No se ha encontrado el controlador de MySQL", e);
		}
	}

	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			throw new DaoException("No se ha podido conectar a la base de datos", e);
		}
	}

	@Override
	public Iterable<Persona> obtenerTodos() {
		try (Connection con = obtenerConexion(); PreparedStatement ps = con.prepareStatement(SQL_SELECT);) {
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Persona> personas = new ArrayList<>();
			
			while(rs.next()) {
				Date fechaNacimientoDate = rs.getDate("fecha_nacimiento");
				LocalDate fechaNacimiento = fechaNacimientoDate != null ? fechaNacimientoDate.toLocalDate() : null;
				personas.add(new Persona(rs.getLong("id"), rs.getString("nombre"), fechaNacimiento));
			}
			
			return personas;
		} catch (SQLException e) {
			throw new DaoException("No se han podido obtener todos los registros", e);
		}
	}

	@Override
	public Persona obtenerPorId(long id) {
		try (Connection con = obtenerConexion(); PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);) {
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Persona persona = null;
			
			if(rs.next()) {
				Date fechaNacimientoDate = rs.getDate("fecha_nacimiento");
				LocalDate fechaNacimiento = fechaNacimientoDate != null ? fechaNacimientoDate.toLocalDate() : null;
				persona = new Persona(rs.getLong("id"), rs.getString("nombre"), fechaNacimiento);
			}
			
			return persona;
		} catch (SQLException e) {
			throw new DaoException("No se ha podido obtener la persona " + id, e);
		}
	}

}
