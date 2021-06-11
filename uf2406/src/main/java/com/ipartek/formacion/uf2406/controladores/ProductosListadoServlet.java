package com.ipartek.formacion.uf2406.controladores;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2406.accesodatos.ProductoDao;
import com.ipartek.formacion.uf2406.modelos.Carrito;
import com.ipartek.formacion.uf2406.modelos.Producto;

@WebServlet("/productos/listado")
public class ProductosListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("productos", ProductoDao.obtenerTodos());

		request.getRequestDispatcher("/WEB-INF/vistas/productos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();

		Long id;
		int cantidad;
		String valor;

		Carrito carrito = new Carrito();

		Producto producto;

		for (String clave : map.keySet()) {
			valor = map.get(clave)[0];

//			System.out.println(clave + " = " + valor);

			id = Long.parseLong(clave);
			cantidad = Integer.parseInt(valor);

//			System.out.println(id + " = " + cantidad);

			producto = ProductoDao.obtenerPorId(id);
			producto.setCantidad(cantidad);

			carrito.agregarProducto(producto);
		}

		request.setAttribute("carrito", carrito);

		request.getRequestDispatcher("/WEB-INF/vistas/carrito.jsp").forward(request, response);

//		String sId;
//		String sCantidad;
//		
//		Enumeration<String> ids = request.getParameterNames();
//		
//		
//		while(ids.hasMoreElements()) {
//			sId = ids.nextElement();
//			sCantidad = request.getParameter(sId);
//			
//			id = Long.parseLong(sId);
//			
//			if(sCantidad != null && sCantidad.trim().length() > 0 ) {
//				cantidad = Integer.parseInt(sCantidad);
//			} else {
//				cantidad = 0;
//			}
//			
//			System.out.println(id + " = " + cantidad);
//		}
	}
}
