package com.ipartek.formacion.uf2406;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sesion-leer")
public class SesionLeerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String usuario = (String) session.getAttribute("usuario");
		out.println(usuario);
		
		out.println(new Date(session.getCreationTime()));
		out.println(new Date(session.getLastAccessedTime()));
		out.println(session.getMaxInactiveInterval()/60);
	}

}
