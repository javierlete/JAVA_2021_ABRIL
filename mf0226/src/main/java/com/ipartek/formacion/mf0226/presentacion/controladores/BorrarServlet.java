package com.ipartek.formacion.mf0226.presentacion.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.mf0226.entidades.BolsaTrabajo;

@WebServlet(name = "borrarPersonaServlet", urlPatterns = { "/borrar" })
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		
		BolsaTrabajo bolsa = (BolsaTrabajo) session.getAttribute("bolsa");
		
		bolsa.eliminarPersona(Long.parseLong(id));
		
		request.getRequestDispatcher("/WEB-INF/vistas/bolsa.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
