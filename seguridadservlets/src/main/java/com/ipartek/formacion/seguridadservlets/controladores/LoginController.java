package com.ipartek.formacion.seguridadservlets.controladores;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.seguridadservlets.daos.DaoMySqlUsuario;
import com.ipartek.formacion.seguridadservlets.entidades.Usuario;

import lombok.extern.java.Log;

@Log
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		log.info(email);
		log.info(password);
		
		Usuario usuario = new Usuario(null, null, email, password, null);
		Usuario usuarioBdd = DaoMySqlUsuario.obtenerDao().obtenerPorEmail(usuario.getEmail());
		
		if(usuarioBdd == null || !usuarioBdd.getPassword().equals(usuario.getPassword())) {
			response.sendRedirect(request.getContextPath() + "/login?error=" + URLEncoder.encode("El usuario o la contraseña son incorrectos", "UTF-8"));
			return;
		}
		
		request.getSession().setAttribute("usuario", usuarioBdd);
		
		response.sendRedirect(request.getContextPath());
	}

}
