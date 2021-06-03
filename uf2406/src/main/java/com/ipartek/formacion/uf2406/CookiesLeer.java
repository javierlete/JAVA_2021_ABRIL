package com.ipartek.formacion.uf2406;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookies-leer")
public class CookiesLeer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		PrintWriter out = response.getWriter();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("color".equals(cookie.getName())) {
					out.println("El color es " + cookie.getValue());
				}
				out.println(cookie.getName());
				out.println(cookie.getValue());
			}
		}
	}
}
