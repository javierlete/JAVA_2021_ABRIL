package com.ipartek.formacion.accesodatos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.modelos.Cliente;

@WebServlet("/api/clientes/*")
public class ClienteRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Dao<Cliente> dao = DaoClienteMySql.getDao();

	private static final Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = obtenerIdUrl(request);

		if (id == null) {

			Iterable<Cliente> clientes = dao.obtenerTodos();

			response.getWriter().write(gson.toJson(clientes));
		} else {
			Cliente cliente = dao.obtenerPorId(id);
			
			response.getWriter().write(gson.toJson(cliente));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cliente cliente = gson.fromJson(request.getReader(), Cliente.class);
		
		cliente = dao.insertar(cliente);
		
		response.getWriter().write(gson.toJson(cliente));
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cliente cliente = gson.fromJson(request.getReader(), Cliente.class);
		
		dao.modificar(cliente);
		
		response.getWriter().write(gson.toJson(cliente));
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = obtenerIdUrl(request);

		if(id != null) {
			dao.borrar(id);
		}
	}
	
	private Long obtenerIdUrl(HttpServletRequest request) {
		String path = request.getPathInfo();

		return path == null || path.length() == 1 ? null : Long.parseLong(path.substring(1));
	}

}
