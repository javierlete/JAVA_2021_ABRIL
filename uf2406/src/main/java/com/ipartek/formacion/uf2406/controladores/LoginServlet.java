package com.ipartek.formacion.uf2406.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2406.accesodatos.UsuarioDao;
import com.ipartek.formacion.uf2406.modelos.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final String PRINCIPAL_JSP = "/WEB-INF/vistas/principal.jsp";
	private static final String LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recoger la informaci�n necesaria de la petici�n
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// 2. Empaquetar la informaci�n en objetos del modelo
		Usuario usuario = new Usuario(null, email, password, null);
		
		// 3. Procesar la informaci�n
		Usuario usuarioValidado = validarUsuario(usuario);
		
		if(usuarioValidado != null) {
			// Login correcto
			// 4. Preparar informaci�n para la siguiente pantalla
			request.getSession().setAttribute("usuario", usuarioValidado);
			// 5. Mandar la petici�n a la siguiente pantalla
			request.getRequestDispatcher(PRINCIPAL_JSP).forward(request, response);
		} else {
			// Login incorrecto
			// 4. Preparar informaci�n para la siguiente pantalla
			request.setAttribute("usuario", usuario);
			request.setAttribute("error", "Usuario o contrase�a incorrectos");
			// 5. Mandar la petici�n a la siguiente pantalla
			request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}
	}

	private Usuario validarUsuario(Usuario usuario) {
		// return "javier@email.net".equals(usuario.getEmail()) && "contra".equals(usuario.getPassword());
		
		Usuario usuarioEncontrado = UsuarioDao.obtenerPorEmail(usuario.getEmail());
		
		if( usuarioEncontrado != null && usuarioEncontrado.getPassword().equals(usuario.getPassword()))
			return usuarioEncontrado;
		else
			return null;
	}
}
