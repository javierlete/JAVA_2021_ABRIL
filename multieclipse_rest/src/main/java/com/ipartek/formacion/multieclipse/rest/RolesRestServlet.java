package com.ipartek.formacion.multieclipse.rest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.multieclipse.dal.Dao;
import com.ipartek.formacion.multieclipse.dal.DaoMySqlRol;
import com.ipartek.formacion.multieclipse.entidades.Rol;

@WebServlet("/roles/*")
public class RolesRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Dao<Rol> dao = DaoMySqlRol.obtenerInstancia();
	
	private static final Gson gson = new Gson();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		
		Long id = obtenerIdPath(request);
		
		String respuesta = null;
		
		if(id != null) {
			Rol rol = dao.obtenerPorId(id);
			respuesta = gson.toJson(rol);
		} else {
			Iterable<Rol> roles = dao.obtenerTodos();
			respuesta = gson.toJson(roles);
		}
			
		out.write(respuesta);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		Rol rol = gson.fromJson(request.getReader(), Rol.class);
		
		Rol insertado = dao.insertar(rol);
		
		response.getWriter().write(gson.toJson(insertado));
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		Rol rol = gson.fromJson(request.getReader(), Rol.class);
		
		Rol modificado = dao.modificar(rol);
		
		response.getWriter().write(gson.toJson(modificado));
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = obtenerIdPath(request);
		
		dao.borrar(id);
	}

	private Long obtenerIdPath(HttpServletRequest request) {
		String path = request.getPathInfo();
		
		Long id = null;
		
		if(path != null) {
			id = Long.parseLong(path.replace("/", ""));
		}
		return id;
	}
}
