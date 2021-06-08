package com.ipartek.formacion.uf2406.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2406.modelos.Producto;

@WebServlet("/productos/listado")
public class ProductosListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Producto> productos = new ArrayList<>();
		
		productos.add(new Producto(1L, "Ratón", new BigDecimal("12.34")));
		productos.add(new Producto(2L, "Monitor", new BigDecimal("123.34")));
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("/WEB-INF/vistas/productos.jsp").forward(request, response);
	}
}
