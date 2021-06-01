package com.ipartek.formacion.uf2406;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saludar")
public class SaludarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String puntos = request.getParameter("puntos");
		
		int cantidad = Integer.parseInt(puntos);
		
		int total = cantidad * 2;
		
		response.getWriter().println("Hola " + nombre + " y la cantidad * 2 es " + total);
	}
}
