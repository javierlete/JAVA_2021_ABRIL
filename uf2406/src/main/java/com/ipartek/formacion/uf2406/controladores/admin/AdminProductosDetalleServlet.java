package com.ipartek.formacion.uf2406.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2406.accesodatos.ProductoDao;
import com.ipartek.formacion.uf2406.modelos.Producto;

@WebServlet("/admin/producto")
public class AdminProductosDetalleServlet extends HttpServlet {
	private static final String PRODUCTODETALLE_JSP = "/WEB-INF/vistas/admin/productodetalle.jsp";
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id != null) {
			request.setAttribute("producto", ProductoDao.obtenerPorId(Long.parseLong(id)));
		}
		
		request.getRequestDispatcher(PRODUCTODETALLE_JSP).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		
		Producto producto = new Producto(id, nombre, precio);
		
		if(producto.getErrores().size() != 0) {
			request.setAttribute("producto", producto);
			request.getRequestDispatcher(PRODUCTODETALLE_JSP).forward(request, response);
			return;
		}
		
		if(producto.getId() != null) {
			ProductoDao.modificar(producto);
		} else {
			ProductoDao.insertar(producto);
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/productos");
	}
}
