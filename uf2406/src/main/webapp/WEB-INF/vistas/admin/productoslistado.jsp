<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-striped table-hovered table-bordered">
	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Opciones</th>
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
				<td><a class="btn btn-primary" href="admin/producto?id=${producto.id}">Editar</a> <a class="btn btn-danger"
					onclick="javascript: return confirm('¿Estás seguro de querer borrar el registro cuyo id es ${producto.id}?')"
					href="admin/borrar?id=${producto.id}">Borrar</a></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td><a class="btn btn-primary" href="admin/producto">Añadir</a></td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>