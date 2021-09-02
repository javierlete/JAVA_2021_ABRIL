package com.ipartek.formacion.uf2177repaso.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.uf2177repaso.entidades.Mueble;

public class DaoMueble implements Dao<Mueble> {

	private static final String URL = "jdbc:mysql://localhost:3306/uf2177repaso";
	private static final String SQL_OBTENER_TODOS = "SELECT * FROM muebles";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";

	@Override
	public Iterable<Mueble> obtenerTodos() {
		try {
			Connection con= DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement(SQL_OBTENER_TODOS);
			ResultSet rs = ps.executeQuery();
			
			List<Mueble> muebles = new ArrayList<Mueble>();
			
			while(rs.next()) {
				muebles.add(new Mueble(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("largo"), rs.getDouble("ancho"), rs.getDouble("alto")));
			}
			
			return muebles;
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido obtener todos los registros", e);
		}
	}
	
}
