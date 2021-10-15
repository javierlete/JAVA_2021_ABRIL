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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		PrintWriter out = response.getWriter();

		Long id = obtenerIdPath(request);

		String respuesta = null;

		if(id != null && id == 0L) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		if (id != null) {
			Rol rol = dao.obtenerPorId(id);
			
			if(rol == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			respuesta = gson.toJson(rol);
		} else {
			Iterable<Rol> roles = dao.obtenerTodos();
			respuesta = gson.toJson(roles);
		}

		out.write(respuesta);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		Long id = obtenerIdPath(request);
		
		if(id != null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		Rol rol = gson.fromJson(request.getReader(), Rol.class);

		Rol insertado = dao.insertar(rol);

		response.setStatus(HttpServletResponse.SC_CREATED);
		response.getWriter().write(gson.toJson(insertado));
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		Long id = obtenerIdPath(request);

		Rol rol = gson.fromJson(request.getReader(), Rol.class);
		
		if(id == null || id == 0 || rol == null || id != rol.getId()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		Rol modificado = dao.modificar(rol);

		response.getWriter().write(gson.toJson(modificado));
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = obtenerIdPath(request);

		if(id == null || id == 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		dao.borrar(id);
		
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	/**
	 * Este método obtiene del Path el id que contiene
	 * @param request la request que contiene el path
	 * @return si no hay path <code>null</code>, si hay path pero no es correcto <code>0L</code> y si hay un valor numérico ese valor numérico
	 */
	private Long obtenerIdPath(HttpServletRequest request) {
		String path = request.getPathInfo();

		if (path != null) {
			try {
				return Long.parseLong(path.replace("/", ""));
			} catch (Exception e) {
				return 0L;
			}
		} else {
			return null;
		}
		
	}
}
