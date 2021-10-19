package com.ipartek.formacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

// https://www.baeldung.com/upload-file-servlet

@WebServlet("/recibirfichero")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
public class RecibeFicheroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) uploadDir.mkdir();
		
		// String fichero = request.getParameter("fichero");
		String fichero;
		
		String pathCompleto;
		BufferedReader br;
		
		out.println("niño");
		System.out.println("niño");
		
		for (Part part : request.getParts()) {
		    fichero = part.getSubmittedFileName();

		    out.println(fichero);

		    pathCompleto = uploadPath + File.separator + fichero;
		    
		    part.write(pathCompleto);
		    
		    br = new BufferedReader(new InputStreamReader(part.getInputStream())); //new FileReader(pathCompleto));
		    
		    String linea;
		    while((linea = br.readLine()) != null) {
		    	System.out.println(linea);
		    	out.println(linea);
		    }
		}
	}
}
