package com.ipartek.formacion.uf2406.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.ipartek.formacion.uf2406.modelos.Producto;

public class ProductoDao {
	private static TreeMap<Long, Producto> productos = new TreeMap<>();
	
	static {
		productos.put(1L, new Producto(1L, "Ratón", new BigDecimal("12.34")));
		productos.put(2L, new Producto(2L, "Monitor", new BigDecimal("123.34")));
		productos.put(3L, new Producto(3L, "Portátil", new BigDecimal("1234.34")));
	}
	
	public static Iterable<Producto> obtenerTodos() {
		return productos.values();
	}
	
	public static Producto obtenerPorId(Long id) {
		return productos.get(id);
	}
	
	public static void insertar(Producto producto) {
		Long id = productos.size() > 0 ? productos.lastKey() + 1L : 1L;
		producto.setId(id);
		productos.put(id, producto);
	}
	
	public static void modificar(Producto producto) {
		productos.put(producto.getId(), producto);
	}
	
	public static void borrar(Long id) {
		productos.remove(id);
	}
}
