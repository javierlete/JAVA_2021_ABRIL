package com.ipartek.formacion.uf2406;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		String op = request.getParameter("op");

		System.out.println(op1);
		System.out.println(op2);
		System.out.println(op);

		PrintWriter out = response.getWriter();

//		out.println(op1);
//		out.println(op2);
//		out.println(op);

		int num1 = Integer.parseInt(op1);
		int num2 = Integer.parseInt(op2);
		int res = 0;

		switch (op) {
		case "+":
			res = num1 + num2;
			break;
		case "-":
			res = num1 - num2;
			break;
		case "*":
			res = num1 * num2;
			break;
		case "/":
			res = num1 / num2;
			break;
		}
		
		out.printf("%s %s %s = %s", op1, op, op2, res);
	}

}
