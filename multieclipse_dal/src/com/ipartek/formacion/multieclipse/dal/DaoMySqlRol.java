package com.ipartek.formacion.multieclipse.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.multieclipse.entidades.Rol;

public class DaoMySqlRol implements Dao<Rol> {

	static String URL = "jdbc:mysql://localhost:3306/hibernatetest?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
	static final String USER = "root";
	static final String PASS = "admin";
	
	static final String SQL_SELECT = "SELECT * FROM roles";
	static final String SQL_SELECT_ID = "SELECT * FROM roles WHERE id=?";
	static final String SQL_INSERT = "INSERT INTO roles (nombre) VALUES (?)";
	static final String SQL_UPDATE = "UPDATE roles SET nombre=? WHERE id=?";
	static final String SQL_DELETE = "DELETE FROM roles WHERE id=?";
	
	// Singleton
	private DaoMySqlRol() {
	}

	private static final DaoMySqlRol dao = new DaoMySqlRol();

	public static DaoMySqlRol obtenerInstancia() {
		return dao;
	}
	// Fin Singleton

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha podido cargar el driver", e);
		}
	}

	Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new DalException("No se ha podido conectar a la base de datos", e);
		}
	}

	@Override
	public Iterable<Rol> obtenerTodos() {
		try (Connection con = obtenerConexion()) {
			PreparedStatement ps = con.prepareStatement(SQL_SELECT);
			ResultSet rs = ps.executeQuery();

			ArrayList<Rol> roles = new ArrayList<>();

			while (rs.next()) {
				roles.add(new Rol(rs.getLong("id"), rs.getString("nombre")));
			}

			return roles;
		} catch (Exception e) {
			throw new DalException("Error al obtener todos los registros", e);
		}
	}

	@Override
	public Rol obtenerPorId(long id) {
		try (Connection con = obtenerConexion()) {
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			Rol rol = null;
			
			if (rs.next()) {
				rol = new Rol(rs.getLong("id"), rs.getString("nombre"));
			}

			return rol;
		} catch (Exception e) {
			throw new DalException("Error al obtener el registro cuyo id es " + id, e);
		}
	}

	@Override
	public Rol insertar(Rol rol) {
		try (Connection con = obtenerConexion()) {
			PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, rol.getNombre());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			
			rol.setId(rs.getLong(1));
			
			return rol;
		} catch (Exception e) {
			throw new DalException("Error al insertar el registro", e);
		}
	}

	@Override
	public Rol modificar(Rol rol) {
		try (Connection con = obtenerConexion()) {
			PreparedStatement ps = con.prepareStatement(SQL_UPDATE);
			ps.setString(1, rol.getNombre());
			ps.setLong(2, rol.getId());
			ps.executeUpdate();
			return rol;
		} catch (Exception e) {
			throw new DalException("Error al modificar el registro cuyo id es " + rol.getId(), e);
		}
	}

	@Override
	public void borrar(long id) {
		try (Connection con = obtenerConexion()) {
			PreparedStatement ps = con.prepareStatement(SQL_DELETE);
			ps.setLong(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new DalException("Error al borrar el registro cuyo id es " + id, e);
		}
	}

}
