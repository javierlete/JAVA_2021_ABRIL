package com.ipartek.formacion.multieclipse.dal;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.multieclipse.entidades.Rol;

class DaoMySqlRolTest {

	private static final DaoMySqlRol dao = DaoMySqlRol.obtenerInstancia();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		DaoMySqlRol.URL = DaoMySqlRol.URL + "test";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		try (Connection con = DriverManager.getConnection(DaoMySqlRol.URL, DaoMySqlRol.USER,
				DaoMySqlRol.PASS);) {
			Statement st = con.createStatement();
			st.executeUpdate("TRUNCATE roles");
			st.executeUpdate("INSERT INTO roles (nombre) VALUES ('ADMIN'), ('USER'), ('TESTS'), ('PRUEBA')");
		}
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testObtenerInstancia() {
		DaoMySqlRol dao1 = DaoMySqlRol.obtenerInstancia();

		assertNotNull(dao1);

		DaoMySqlRol dao2 = DaoMySqlRol.obtenerInstancia();

		assertTrue(dao1 == dao2);
	}

	@Test
	void testObtenerConexion() {
		try (Connection con = dao.obtenerConexion();) {
			con.isValid(1000);
		} catch (SQLException e) {
			fail(e.getMessage(), e);
		}
	}

	@Test
	void testObtenerTodos() {
		ArrayList<Rol> roles = (ArrayList<Rol>)dao.obtenerTodos();
		
		assertEquals(4, roles.size());
	}

	@Test
	void testObtenerPorId() {
		Rol rol = dao.obtenerPorId(4L);
		
		assertEquals("PRUEBA", rol.getNombre());
	}

	@Test
	void testInsertar() {
		dao.insertar(new Rol(null, "YEPA"));
		
		Rol rol = dao.obtenerPorId(5L);
		
		assertEquals("YEPA", rol.getNombre());
	}

	@Test
	void testModificar() {
		Rol rol = dao.obtenerPorId(2L);
		
		assertEquals("USER", rol.getNombre());
		
		dao.modificar(new Rol(2L, "MODIFICADO"));
		
		rol = dao.obtenerPorId(2L);
		
		assertEquals("MODIFICADO", rol.getNombre());
	}

	@Test
	void testBorrar() {
		dao.borrar(3L);
		
		assertNull(dao.obtenerPorId(3L));
	}

}
