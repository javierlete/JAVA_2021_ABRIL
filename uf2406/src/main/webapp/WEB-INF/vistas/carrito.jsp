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

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<%-- Repetimos por cada producto dentro de productos --%>
			<c:forEach items="${carrito.productos}" var="producto">
				<tr>
					<%-- <%= producto.getId() %> --%>
					<th>${producto.id}</th>
					<td>${producto.nombre}</td>
					<td>${producto.precio}</td>
					<td>${producto.cantidad}</td>
					<td>${producto.total}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>${carrito.total}</td>
			</tr>
		</tfoot>
	</table>


</body>
</html>