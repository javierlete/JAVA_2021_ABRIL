<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrito</title>
</head>
<body>

	<h1>Your choice was</h1>

	<table>
		<thead>
			<tr>
				<th>Number</th>
				<th>Name</th>
				<th>Price</th>
				<th>Number</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${carrito}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.nombre}</td>
				<td>${p.precio}</td>
				<td>${p.cantidad}</td>
				<td>${p.total}</td>
			</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>${total}</td>
			</tr>
		</tfoot>
	</table>
	
	<form method="get">
		<button>Pay</button>
	</form>

</body>
</html>