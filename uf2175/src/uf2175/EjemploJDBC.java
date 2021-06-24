package uf2175;

import java.sql.*;

public class EjemploJDBC {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mf0226";
		String usuario = "root";
		String password = "admin";

		Connection con = DriverManager.getConnection(url, usuario, password);
		
		ResultSet rs;
		mostrarRegistros(con);
		
		String id = "2";
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM personas WHERE id = ?");
		ps.setInt(1, Integer.parseInt(id));
		//rs = st.executeQuery("SELECT * FROM personas WHERE id = " + id);
		rs = ps.executeQuery();
		
		while (rs.next()) {
			System.out.println(String.format("%s, %s, %s", 
					rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos")));
		}
		
		String nombre = "Insertado";
		String apellidos = "Insertadez";
		
		ps = con.prepareStatement("INSERT INTO personas (nombre, apellidos) VALUES (?, ?)");
		
		ps.setString(1, nombre);
		ps.setString(2, apellidos);
		
		int numeroRegistrosModificados = ps.executeUpdate();
		
		System.out.println(numeroRegistrosModificados);
		
		mostrarRegistros(con);
		
		nombre = "Modificado";
		apellidos = "Modificadez";
		
		ps = con.prepareStatement("UPDATE personas SET nombre=?, apellidos=? WHERE id=?");
		
		ps.setString(1, nombre);
		ps.setString(2, apellidos);
		ps.setInt(3, Integer.parseInt(id));
		
		numeroRegistrosModificados = ps.executeUpdate();
		
		System.out.println(numeroRegistrosModificados);
		
		mostrarRegistros(con);
		
		ps = con.prepareStatement("DELETE FROM personas WHERE id=?");
		
		ps.setInt(1, Integer.parseInt(id));
		
		numeroRegistrosModificados = ps.executeUpdate();
		
		System.out.println(numeroRegistrosModificados);
		
		mostrarRegistros(con);
		
		con.close();
	}

	private static void mostrarRegistros(Connection con) throws SQLException {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM personas");

		while (rs.next()) {
			System.out.println(String.format("%s, %s, %s", 
					rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos")));
		}
		
		rs.close();
		st.close();
	}

}
