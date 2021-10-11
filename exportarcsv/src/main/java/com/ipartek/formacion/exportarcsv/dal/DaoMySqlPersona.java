package com.ipartek.formacion.exportarcsv.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ipartek.formacion.exportarcsv.entidades.Persona;

public class DaoMySqlPersona implements Dao<Persona> {

	private static final String URL = "jdbc:mysql://localhost:3306/hibernate";
	private static final String USER = "root";
	private static final String PASS = "admin";
	
	private static final String SQL_SELECT = "SELECT * FROM personas";
	
	// Singleton
	private DaoMySqlPersona() {}
	private static final DaoMySqlPersona dao = new DaoMySqlPersona();
	public static DaoMySqlPersona obtenerDao() {
		return dao;
	}
	// Fin Singleton
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha podido cargar el driver de MySQL", e);
		}
	}
	
	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new DalException("Fallo de conexión", e);
		}
	}
	
	@Override
	public Iterable<Persona> obtenerTodos() {
		try(
				Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT);
				ResultSet rs = ps.executeQuery();
				) {
			
			ArrayList<Persona> personas = new ArrayList<Persona>();
			
			java.sql.Date fechaNacimientoDate;
			LocalDate fechaNacimiento;
			
			while(rs.next()) {
				fechaNacimientoDate = rs.getDate("fecha_nacimiento");
				fechaNacimiento = fechaNacimientoDate == null ? null : fechaNacimientoDate.toLocalDate();
				
				personas.add(new Persona(rs.getLong("id"), rs.getString("nombre"), fechaNacimiento));
			}
			
			return personas;
		} catch (SQLException e) {
			throw new DalException("No se han obtener las personas", e);
		}
	}
}
