package com.ipartek.formacion.mf0226.presentacion.controladores.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.mf0226.accesodatos.PersonaDao;

@WebServlet("/admin/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");

		try {
			PersonaDao.borrar(Long.parseLong(id));
			session.setAttribute("textoMensaje", "Persona borrada correctamente");
			session.setAttribute("tipoMensaje", "success");
		} catch (Exception e) {
			session.setAttribute("textoMensaje", "No se ha podido borrar la persona");
			session.setAttribute("tipoMensaje", "danger");
		}

		response.sendRedirect(request.getContextPath() + "/admin");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
