package com.ipartek.formacion.mf0226.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.mf0226.entidades.Ocupacion;
import static com.ipartek.formacion.mf0226.accesodatos.Globales.*;

public class OcupacionDao {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver", e);
		}
	}
	private static Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL_BD, USUARIO_BD, PASSWORD_BD);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar con la base de datos", e);
		}
	}

	public static Iterable<Ocupacion> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM ocupaciones");
				ResultSet rs = ps.executeQuery()) {
			ArrayList<Ocupacion> ocupaciones = new ArrayList<>();

			while (rs.next()) {
				ocupaciones.add(new Ocupacion(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion")));
			}

			return ocupaciones;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener los registros", e);
		}

	}

	public static Ocupacion obtenerPorId(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM ocupaciones WHERE id = ?")) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			Ocupacion ocupacion = null;

			if (rs.next()) {
				ocupacion = new Ocupacion(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"));
			}

			return ocupacion;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro " + id, e);
		}
	}

	public static void insertar(Ocupacion ocupacion) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("INSERT INTO ocupaciones (nombre, descripcion) VALUES (?,?)")) {
			ps.setString(1, ocupacion.getNombre());
			ps.setString(2, ocupacion.getDescripcion());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el registro " + ocupacion, e);
		}
	}
	
	public static void modificar(Ocupacion ocupacion) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("UPDATE ocupaciones SET nombre=?,descripcion=? WHERE id=?")) {
			ps.setString(1, ocupacion.getNombre());
			ps.setString(2, ocupacion.getDescripcion());
			ps.setLong(3, ocupacion.getId());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el registro " + ocupacion, e);
		}
	}
	
	public static void borrar(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("DELETE FROM ocupaciones WHERE id=?")) {
			ps.setLong(1, id);
			
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido borrar el registro " + id, e);
		}
	}
}
