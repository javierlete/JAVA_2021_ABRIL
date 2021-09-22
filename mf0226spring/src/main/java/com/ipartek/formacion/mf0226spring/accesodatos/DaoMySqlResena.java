package com.ipartek.formacion.mf0226spring.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.mf0226spring.modelos.ResenaCodigos;

@Repository
public class DaoMySqlResena implements Dao<ResenaCodigos> {
	private static final String URL = "jdbc:mysql://localhost:3306/gestiondocente";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "admin";
	
	private static final String SQL_INSERT = "INSERT INTO resenas (alumno_codigo, curso_codigo, texto) VALUES (?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE resenas SET texto = ? WHERE alumno_codigo = ? AND curso_codigo = ?";
	private static final String SQL_DELETE = "DELETE FROM resenas WHERE alumno_codigo = ? AND curso_codigo = ?";
	
	@Override
	public ResenaCodigos insertar(ResenaCodigos resena) {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_INSERT);
				) {
			ps.setInt(1, resena.getAlumnoCodigo());
			ps.setInt(2, resena.getCursoCodigo());
			ps.setString(3, resena.getTexto());
			
			ps.executeUpdate();
				
			return resena;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al insertar la reseña " + resena.getTexto(), e);
		}
	}

	@Override
	public ResenaCodigos modificar(ResenaCodigos resena) {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);
				) {
			ps.setInt(2, resena.getAlumnoCodigo());
			ps.setInt(3, resena.getCursoCodigo());
			ps.setString(1, resena.getTexto());
			
			ps.executeUpdate();
				
			return resena;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al modificar la reseña " + resena.getTexto(), e);
		}
	}

	@Override
	public void borrar(ResenaCodigos resena) {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);
				) {
			ps.setInt(1, resena.getAlumnoCodigo());
			ps.setInt(2, resena.getCursoCodigo());
			
			ps.executeUpdate();
				
		} catch (Exception e) {
			throw new AccesoDatosException("Error al insertar la reseña " + resena.getTexto(), e);
		}
	}

}
