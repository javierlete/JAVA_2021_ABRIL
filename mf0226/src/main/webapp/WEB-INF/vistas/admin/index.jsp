<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-striped table-hover table-bordered">
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Sueldo</th>
			<th>Ocupación</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${personas}" var="p">
			<tr>
				<th>${p.id}</th>
				<td>${p.nombre}</td>
				<td>${p.apellidos}</td>
				<td>
					<fmt:formatNumber type="currency" value="${p.sueldo}" />
				</td>
				<td>${p.ocupacion.nombre}</td>
				<td><a class="btn btn-primary" href="admin/persona?id=${p.id}">Editar</a>
					<a class="btn btn-danger"
					onclick="return confirm('¿Estás seguro?')"
					href="admin/borrar?id=${p.id}">Borrar</a></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><a class="btn btn-primary" href="admin/persona">Añadir</a></td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
