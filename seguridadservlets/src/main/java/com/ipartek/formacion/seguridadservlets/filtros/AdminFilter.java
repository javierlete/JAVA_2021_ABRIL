package com.ipartek.formacion.seguridadservlets.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.seguridadservlets.entidades.Usuario;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		
		if(usuario == null || !usuario.getRol().getNombre().equals("ADMIN")) {
			res.sendRedirect(req.getContextPath() + "/login?error=Debes ser administrador para poder entrar");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
