package com.ipartek.formacion.mf0226.presentacion.controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0226.accesodatos.PersonaDao;
import com.ipartek.formacion.mf0226.entidades.Persona;

@WebServlet("/admin")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("personas", PersonaDao.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
		
//		response.setContentType("text/plain");
//		PrintWriter out = response.getWriter();
		
//		for (Persona persona : PersonaDao.obtenerTodos()) {
//			out.println(persona);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
