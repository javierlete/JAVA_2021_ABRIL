package com.ipartek.formacion.multieclipse.rest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.multieclipse.dal.Dao;
import com.ipartek.formacion.multieclipse.dal.DaoMySqlRol;
import com.ipartek.formacion.multieclipse.entidades.Rol;

@WebServlet("/roles/*")
public class RolesRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Dao<Rol> dao = DaoMySqlRol.obtenerInstancia();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		
		PrintWriter out = response.getWriter();
		
		Iterable<Rol> roles = dao.obtenerTodos();
		
		for(Rol rol: roles) {
			out.println(rol);
		}
	}
}
