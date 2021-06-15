package com.ipartek.formacion.uf2406_2.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2406_2.modelos.Producto;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static TreeMap<Long, Producto> productos = new TreeMap<>();

	static {
		productos.put(111L, new Producto(111L, "motores", new BigDecimal(34347), null));
		productos.put(222L, new Producto(222L, "escoba", new BigDecimal(760), null));
		productos.put(333L, new Producto(333L, "lapiz", new BigDecimal(123), null));
		productos.put(444L, new Producto(444L, "goma", new BigDecimal(224), null));
		productos.put(555L, new Producto(555L, "papel", new BigDecimal(322), null));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("productos", productos.values());
		request.getRequestDispatcher("/WEB-INF/vistas/listado.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> parametros = request.getParameterMap();

		String clave, valor;
		Long id;
		Integer cantidad;

		ArrayList<Producto> carrito = new ArrayList<>();
		Producto producto;

		BigDecimal total = BigDecimal.ZERO;

		for (Entry<String, String[]> parametro : parametros.entrySet()) {
			// name , value
			// 111=1&222=2&333=3&444=4
			// 111 , 1
			clave = parametro.getKey(); // 111
			valor = parametro.getValue()[0]; // 1

			id = Long.parseLong(clave);
			
			if (valor.trim().length() != 0) {
				cantidad = Integer.parseInt(valor);
			} else {
				cantidad = 0;
			}

			if (cantidad > 0) {
				producto = productos.get(id);
				producto.setCantidad(cantidad);

				total = total.add(producto.getTotal());

				carrito.add(producto);
			}
		}

		request.setAttribute("carrito", carrito);
		request.setAttribute("total", total);
		
		request.getRequestDispatcher("/WEB-INF/vistas/carrito.jsp").forward(request, response);
	}

}
