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
	private static final String USER = "root";
	private static final String PASSWORD = "admin";
	private static final String SQL_OBTENER_TODOS = "SELECT * FROM muebles";
	private static final String SQL_OBTENER_POR_ID = SQL_OBTENER_TODOS + " WHERE id = ?";
	private static final String SQL_BORRAR = "DELETE FROM muebles WHERE id = ?";
	private static final String SQL_MODIFICAR = "UPDATE muebles SET nombre=?,largo=?,ancho=?,alto=? WHERE id=?";

	@Override
	public Iterable<Mueble> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_OBTENER_TODOS);
				ResultSet rs = ps.executeQuery()) {

			List<Mueble> muebles = new ArrayList<Mueble>();

			while (rs.next()) {
				muebles.add(new Mueble(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("largo"),
						rs.getDouble("ancho"), rs.getDouble("alto")));
			}

			return muebles;
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido obtener todos los registros", e);
		}
	}

	@Override
	public Mueble obtenerPorId(Long id) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_OBTENER_POR_ID);) {
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Mueble(rs.getLong("id"), rs.getString("nombre"), rs.getDouble("largo"),
						rs.getDouble("ancho"), rs.getDouble("alto"));
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido obtener el registro cuyo id es " + id, e);
		}
	}
	
	@Override
	public Mueble modificar(Mueble mueble) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_MODIFICAR);) {
			ps.setString(1, mueble.getNombre());
			ps.setDouble(2, mueble.getLargo());
			ps.setDouble(3, mueble.getAncho());
			ps.setDouble(4, mueble.getAlto());
			ps.setLong(5, mueble.getId());

			if(ps.executeUpdate() != 1) {
				throw new AccesoDatosException("Se ha modificar un n�mero de registros diferente de uno");
			} else {
				return mueble;
			}
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido modificar el registro cuyo id es " + mueble.getId(), e);
		}
	}
	
	@Override
	public void borrar(Long id) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_BORRAR);) {
			ps.setLong(1, id);

			if(ps.executeUpdate() != 1) {
				throw new AccesoDatosException("Se ha borrado un n�mero de registros diferente de uno");
			}
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido borrar el registro cuyo id es " + id, e);
		}
	}

}
