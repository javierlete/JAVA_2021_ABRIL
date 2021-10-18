package com.ipartek.formacion.multimaven.entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RolTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHashCode() {
		Rol rol1 = new Rol(1L, "Uno");
		Rol rol2 = new Rol(1L, "Uno");
		
		assertEquals(rol1.hashCode(), rol2.hashCode());
	}

	@Test
	void testEqualsObject() {
		Rol rol1 = new Rol(1L, "Uno");
		Rol rol2 = new Rol(1L, "Uno");
		
		assertFalse(rol1 == rol2);
		assertTrue(rol1.equals(rol2));
		
		rol2.setId(2L);
		
		assertFalse(rol1.equals(rol2));
	}

	@Test
	void testToString() {
		Rol rol = new Rol();
		
		rol.setId(5L);
		rol.setNombre("Básico");
		
		assertEquals("Rol(id=5, nombre=Básico)", rol.toString());
	}

	@Test
	void testRolLongString() {
		Rol rol = new Rol(1L, "Prueba");
		
		assertNotNull(rol);
		assertEquals(1L, rol.getId());
		assertEquals("Prueba", rol.getNombre());
	}

}
