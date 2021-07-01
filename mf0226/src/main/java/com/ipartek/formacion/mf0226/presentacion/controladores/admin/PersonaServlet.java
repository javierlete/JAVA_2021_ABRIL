package com.ipartek.formacion.mf0226.presentacion.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.mf0226.accesodatos.PersonaDao;
import com.ipartek.formacion.mf0226.entidades.Persona;

@WebServlet("/admin/persona")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {
			try {
				Persona persona = PersonaDao.obtenerPorId(Long.parseLong(id));

				request.setAttribute("persona", persona);
				request.setAttribute("textoMensaje", "Persona obtenida correctamente");
				request.setAttribute("tipoMensaje", "success");
			} catch (Exception e) {
				request.setAttribute("textoMensaje", "No se ha podido obtener la persona");
				request.setAttribute("tipoMensaje", "danger");
			}
		}

		request.getRequestDispatcher("/WEB-INF/vistas/admin/persona.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");

		Persona persona = new Persona(id, nombre, apellidos);

		if (persona.getId() == null) {
			try {
				PersonaDao.insertar(persona);

				session.setAttribute("textoMensaje", "Persona insertada correctamente");
				session.setAttribute("tipoMensaje", "success");
			} catch (Exception e) {
				session.setAttribute("textoMensaje", "No se ha podido insertar la persona");
				session.setAttribute("tipoMensaje", "danger");
			}
		} else {
			try {
				PersonaDao.modificar(persona);

				session.setAttribute("textoMensaje", "Persona modificada correctamente");
				session.setAttribute("tipoMensaje", "success");
			} catch (Exception e) {
				session.setAttribute("textoMensaje", "No se ha podido modificar la persona");
				session.setAttribute("tipoMensaje", "danger");
			}
		}

		response.sendRedirect(request.getContextPath() + "/admin");
	}

}
