package com.ipartek.formacion.uf2177spring.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.uf2177spring.modelos.Cliente;

@Repository
public class DaoClienteMySql implements Dao<Cliente> {

	private static final String URL = "jdbc:mysql://localhost:3306/uf2177_3";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "admin";
	private static final String SQL_SELECT = "SELECT * FROM clientes";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM clientes WHERE id = ?";
	private static final String SQL_UPDATE = "UPDATE clientes SET nombre=? WHERE id=?";
	private static final String SQL_INSERT = "INSERT INTO clientes (nombre) VALUES (?)";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de la base de datos", e);
		}
	}
	
	@Override
	public Iterable<Cliente> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_SELECT);
				ResultSet rs = ps.executeQuery()) {
			
			List<Cliente> clientes = new ArrayList<>();
			
			while(rs.next()) {
				clientes.add(new Cliente(rs.getLong("id"), rs.getString("nombre")));
			}
			
			return clientes;
			
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido obtener todos los registros", e);
		}
	}

	@Override
	public Cliente obtenerPorId(long id) {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
				) {
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Cliente(rs.getLong("id"), rs.getString("nombre"));
			} else {
				return null;
			}
			
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido obtener el registro " + id, e);
		}
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
				) {
			ps.setString(1, cliente.getNombre());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			rs.next();
			
			cliente.setId(rs.getLong(1));
			
			return cliente;
			
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido insertar el registro " + cliente.getNombre(), e);
		}
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);
				) {
			ps.setString(1, cliente.getNombre());
			ps.setLong(2, cliente.getId());
			
			ps.executeUpdate();
			
			return cliente;
			
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido modificar el registro " + cliente.getId(), e);
		}
	}

	@Override
	public void borrar(long id) {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);
				) {
			ps.setLong(1, id);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido borrar el registro " + id, e);
		}
	}

	
}
