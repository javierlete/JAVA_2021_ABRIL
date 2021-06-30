package com.ipartek.formacion.mf0226.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.mf0226.entidades.Usuario;

public class UsuarioDao {
	private static final String URL_BD = "jdbc:mysql://localhost:3306/mf0226";
	private static final String USUARIO_BD = "root";
	private static final String PASSWORD_BD = "admin";

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

	public static Iterable<Usuario> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios");
				ResultSet rs = ps.executeQuery()) {
			ArrayList<Usuario> usuarios = new ArrayList<>();

			while (rs.next()) {
				usuarios.add(new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"),
						rs.getString("rol")));
			}

			return usuarios;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener los registros", e);
		}

	}

	public static Usuario obtenerPorId(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE id = ?")) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			Usuario usuario = null;

			if (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"),
						rs.getString("rol"));
			}

			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro " + id, e);
		}
	}
	
	public static Usuario obtenerPorEmail(String email) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE email = ?")) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			Usuario usuario = null;

			if (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"),
						rs.getString("rol"));
			}

			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro " + email, e);
		}
	}

	public static void insertar(Usuario usuario) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("INSERT INTO usuarios (email, password, rol) VALUES (?,?,?)")) {
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getPassword());
			ps.setString(3, usuario.getRol());

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el registro " + usuario, e);
		}
	}

	public static void modificar(Usuario usuario) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("UPDATE usuarios SET email=?,password=?,rol=? WHERE id=?")) {
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getPassword());
			ps.setString(3, usuario.getRol());
			ps.setLong(4, usuario.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el registro " + usuario, e);
		}
	}

	public static void borrar(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE id=?")) {
			ps.setLong(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido borrar el registro " + id, e);
		}
	}
}
