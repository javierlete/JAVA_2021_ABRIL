package uf2175;

import java.sql.*;

public class EjemploJDBC {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mf0226";
		String usuario = "root";
		String password = "admin";

		Connection con = DriverManager.getConnection(url, usuario, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM personas");

		while (rs.next()) {
			System.out.println(String.format("%s, %s, %s", 
					rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos")));
		}
		
		rs.close();
		st.close();
		con.close();
	}

}
