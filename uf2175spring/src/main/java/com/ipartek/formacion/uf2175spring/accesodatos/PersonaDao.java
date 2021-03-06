package com.ipartek.formacion.uf2175spring.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ipartek.formacion.uf2175spring.entidades.Persona;

@Component
public class PersonaDao implements Dao<Persona> {
	private String URL_BD = "jdbc:mysql://localhost:3306/mf0226";
	private String USUARIO_BD = "root";
	private String PASSWORD_BD = "admin";

	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL_BD, USUARIO_BD, PASSWORD_BD);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar con la base de datos", e);
		}
	}

	public Iterable<Persona> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM personas");
				ResultSet rs = ps.executeQuery()) {
			ArrayList<Persona> personas = new ArrayList<>();

			while (rs.next()) {
				personas.add(new Persona(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos")));
			}

			return personas;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener los registros", e);
		}

	}

	public Persona obtenerPorId(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM personas WHERE id = ?")) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			Persona persona = null;

			if (rs.next()) {
				persona = new Persona(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"));
			}

			return persona;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro " + id, e);
		}
	}

	public Persona insertar(Persona persona) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("INSERT INTO personas (nombre, apellidos) VALUES (?,?)")) {
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellidos());
			
			ps.executeUpdate();

			return persona;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el registro " + persona, e);
		}
	}
	
	public Persona modificar(Persona persona) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("UPDATE personas SET nombre=?,apellidos=? WHERE id=?")) {
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellidos());
			ps.setLong(3, persona.getId());
			
			ps.executeUpdate();

			return persona;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el registro " + persona, e);
		}
	}
	
	public void borrar(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("DELETE FROM personas WHERE id=?")) {
			ps.setLong(1, id);
			
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido borrar el registro " + id, e);
		}
	}
}
