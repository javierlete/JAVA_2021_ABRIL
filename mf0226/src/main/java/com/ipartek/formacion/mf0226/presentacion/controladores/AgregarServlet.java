package com.ipartek.formacion.mf0226.presentacion.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.mf0226.accesodatos.PersonaDao;
import com.ipartek.formacion.mf0226.entidades.BolsaTrabajo;
import com.ipartek.formacion.mf0226.entidades.Usuario;

@WebServlet("/agregar")
public class AgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		
		BolsaTrabajo bolsa = (BolsaTrabajo) session.getAttribute("bolsa");
		
		if(bolsa == null) {
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			
			if(usuario == null) {
				request.setAttribute("textoMensaje", "Necesitas un usuario para poder rellenar la bolsa de trabajo");
				request.setAttribute("tipoMensaje", "warning");
				
				request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
				return;
			}
			
			bolsa = new BolsaTrabajo(usuario.getEmail());
			
			session.setAttribute("bolsa", bolsa);
		}
		
		bolsa.agregarPersona(PersonaDao.obtenerPorId(Long.parseLong(id)));
		
		//request.getRequestDispatcher("/WEB-INF/vistas/bolsa.jsp").forward(request, response);
		
		response.sendRedirect(request.getContextPath() + "/bolsa");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
