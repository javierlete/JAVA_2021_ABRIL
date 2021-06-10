<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de productos</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
			</tr>
		</thead>
		<tbody>
			<%-- Repetimos por cada producto dentro de productos --%>
			<c:forEach items="${productos}" var="producto">
				<tr>
					<%-- <%= producto.getId() %> --%>
					<th>${producto.id}</th>
					<td>${producto.nombre}</td>
					<td>${producto.precio}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>