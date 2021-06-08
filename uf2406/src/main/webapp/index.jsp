<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo básico de JSP (Java Server Pages)</title>
</head>
<body>

	<% 
	for(int i = 1; i <= 6; i++) 
	{ 
	%>
		<h<%=i %>>Prueba <%=i %></h<%=i %>>
	<% 
	} 
	%>
	
	<h1><%= request.getParameter("nombre") %></h1>

</body>
</html>