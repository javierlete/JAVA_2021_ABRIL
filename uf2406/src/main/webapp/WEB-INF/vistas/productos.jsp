<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- Agregamos la referencia a las etiquetas de JSTL de prefijo c --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
</head>
<body>

	<form method="post">
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Cantidad</th>
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
						<td><input type="number" required min="0"
							name="${producto.id}" value="0" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<button>Comprar</button>

	</form>

</body>
</html>