<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado</title>
</head>
<body>
	<h1>Make your order</h1>

	<form method="post">
		<table>
			<thead>
				<tr>
					<th>Product Number</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Number</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productos}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.nombre}</td>
						<td>${p.precio}</td>
						<td>
							<input name="${p.id}" type="number" min="0" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<button>Process Request</button>
	</form>

</body>
</html>