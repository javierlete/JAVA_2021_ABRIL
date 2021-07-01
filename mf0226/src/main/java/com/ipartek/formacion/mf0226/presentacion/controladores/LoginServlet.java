package com.ipartek.formacion.mf0226.presentacion.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.mf0226.accesodatos.UsuarioDao;
import com.ipartek.formacion.mf0226.entidades.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Usuario usuario = UsuarioDao.obtenerPorEmail(email);

		if (usuario != null && usuario.getPassword().equals(password)) {
			session.setAttribute("textoMensaje", "El usuario ha iniciado sesión correctamente");
			session.setAttribute("tipoMensaje", "success");
			
			session.setAttribute("usuario", usuario);

			if ("ADMIN".equals(usuario.getRol())) {
				response.sendRedirect(request.getContextPath() + "/admin");
			} else {
				response.sendRedirect(request.getContextPath() + "/");
			}
		} else {
			usuario = new Usuario(null, email, null, null);
			
			request.setAttribute("textoMensaje", "Usuario o contraseña incorrectos");
			request.setAttribute("tipoMensaje", "danger");
			
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}

}
