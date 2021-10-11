package com.ipartek.formacion.exportarcsv.controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.exportarcsv.dal.Dao;
import com.ipartek.formacion.exportarcsv.dal.DaoMySqlPersona;
import com.ipartek.formacion.exportarcsv.entidades.Persona;

@WebServlet("/exportar")
public class ExportarCsvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Dao<Persona> dao = DaoMySqlPersona.obtenerDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); //"application/vnd.ms-excel"); // "text/csv");
		response.setCharacterEncoding("UTF-8");
		
		response.setHeader("Content-Disposition", "inline;filename=exportacion.csv");
		
		PrintWriter out = response.getWriter();
		
		out.println("Id;Nombre;FechaNacimiento");
		
		for(Persona persona: dao.obtenerTodos()) {
			out.println(String.format("%s;%s;%s", persona.getId(), persona.getNombre(), persona.getFechaNacimiento()));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
