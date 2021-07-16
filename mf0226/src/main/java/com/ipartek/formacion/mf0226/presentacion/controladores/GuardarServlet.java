package com.ipartek.formacion.mf0226.presentacion.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.mf0226.accesodatos.BolsaTrabajoDao;
import com.ipartek.formacion.mf0226.entidades.BolsaTrabajo;
import com.ipartek.formacion.mf0226.entidades.Usuario;

@WebServlet("/guardar")
public class GuardarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		BolsaTrabajo bolsa = (BolsaTrabajo) session.getAttribute("bolsa");
		
		BolsaTrabajoDao.guardar(usuario.getId(), bolsa);
		
		response.sendRedirect(request.getContextPath() + "/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
