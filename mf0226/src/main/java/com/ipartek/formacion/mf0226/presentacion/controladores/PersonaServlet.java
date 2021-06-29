package com.ipartek.formacion.mf0226.presentacion.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0226.accesodatos.PersonaDao;
import com.ipartek.formacion.mf0226.entidades.Persona;

@WebServlet("/admin/persona")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id != null) {
			Persona persona = PersonaDao.obtenerPorId(Long.parseLong(id));
			request.setAttribute("persona", persona);
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/persona.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
