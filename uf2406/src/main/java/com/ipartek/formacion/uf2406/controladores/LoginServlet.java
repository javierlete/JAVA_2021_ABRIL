package com.ipartek.formacion.uf2406.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final String PRINCIPAL_JSP = "/WEB-INF/vistas/principal.jsp";
	private static final String LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recoger la información necesaria de la petición
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// 2. Procesar la información
		if("javier@email.net".equals(email) && "contra".equals(password)) {
			// Login correcto
			// 3. Preparar información para la siguiente pantalla
			request.getSession().setAttribute("email", email);
			// 4. Mandar la petición a la siguiente pantalla
			request.getRequestDispatcher(PRINCIPAL_JSP).forward(request, response);
		} else {
			// Login incorrecto
			// 3. Preparar información para la siguiente pantalla
			request.setAttribute("email", email);
			request.setAttribute("error", "Usuario o contraseña incorrectos");
			// 4. Mandar la petición a la siguiente pantalla
			request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}
	}
	
	
}
