package com.ipartek.formacion.uf2406;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookies-escribir")
public class CookiesEscribir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("color", "rojo");
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
		response.getWriter().println("Cookie enviada");
	}
}
