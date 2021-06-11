package com.ipartek.formacion.uf2406.modelos;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Carrito {
	private ArrayList<Producto> productos = new ArrayList<>();

	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}

	public Iterable<Producto> getProductos() {
		return productos;
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;

		for (Producto producto : productos) {
			total = total.add(producto.getTotal());
		}

		return total;
	}
}
