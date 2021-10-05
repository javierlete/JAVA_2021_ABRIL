package com.ipartek.formacion.seguridadservlets.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.seguridadservlets.entidades.Rol;
import com.ipartek.formacion.seguridadservlets.entidades.Usuario;

public class DaoMySqlUsuario implements DaoUsuario {

	private static final String URL = "jdbc:mysql://localhost:3306/hibernate";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";
	private static final String SQL_EMAIL = "SELECT * FROM usuarios u JOIN roles r ON u.rol_id = r.id WHERE email = ?";

	private static DaoMySqlUsuario dao = new DaoMySqlUsuario();
	private DaoMySqlUsuario() {}
	public static DaoMySqlUsuario obtenerDao() { return dao; }
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DaosException("No se ha podido cargar el driver de MySQL", e);
		}
	}

	@Override
	public Usuario obtenerPorEmail(String email) {
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_EMAIL);
				){
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			Usuario usuario = null;
			Rol rol = null;
			
			if(rs.next()) {
				rol = new Rol(rs.getLong("r.id"), rs.getString("r.nombre"));
				usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.nombre"), rs.getString("u.email"), rs.getString("u.password"), rol);
			}
			
			return usuario;
		} catch (SQLException e) {
			throw new DaosException("No se ha podido obtener el usuario por su email", e);
		}
	}

}
