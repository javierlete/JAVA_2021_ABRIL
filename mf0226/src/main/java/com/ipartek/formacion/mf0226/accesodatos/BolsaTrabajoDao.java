package com.ipartek.formacion.mf0226.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ipartek.formacion.mf0226.entidades.BolsaTrabajo;
import com.ipartek.formacion.mf0226.entidades.Persona;

public class BolsaTrabajoDao {
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
	
	public static void guardar(Long usuarioId, BolsaTrabajo bolsa) {
		try (Connection con = obtenerConexion();
				) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO bolsas (empresa, usuarios_id) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, bolsa.getEmpresa());
			ps.setLong(2, usuarioId);
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			
			Long bolsaId =  rs.getLong(1);
			
			ps = con.prepareStatement("INSERT INTO bolsas_has_personas (bolsas_id, personas_id) VALUES (?, ?)");
			
			ps.setLong(1, bolsaId);
			
			for(Persona persona: bolsa.getPersonas()) {
				ps.setLong(2, persona.getId());
				
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar la bolsa de trabajo de " + bolsa.getEmpresa(), e);
		}
	}
}
