<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<caption>Personas</caption>
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nombre</th>
				<th scope="col">Fecha de nacimiento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${personas}" var="persona">
				<tr>
					<th scope="row">${persona.id}</th>
					<td>${persona.nombre}</td>
					<td>${persona.fechaNacimiento}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>