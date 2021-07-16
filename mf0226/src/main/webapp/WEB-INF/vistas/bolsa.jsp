<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>${bolsa.empresa}</h2>

<table class="table table-hover table-striped table-bordered">
	<thead class="table-dark">
		<tr>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Ocupación</th>
			<th>Descripción de la ocupación</th>
			<th>Foto</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${bolsa.personas}" var="p">
			<tr>
				<td class="align-middle">${p.nombre}</td>
				<td class="align-middle">${p.apellidos}</td>
				<td class="align-middle">${p.ocupacion.nombre}</td>
				<td class="align-middle">${p.ocupacion.descripcion}</td>
				<td class="align-middle">
					<img style="height: 4rem" class="img-thumbnail" src="fotos/${p.id}.jpg" alt="Foto ${p.nombre} ${p.apellidos}" />
				</td>
				<td class="align-middle">
					<a class="btn btn-danger" href="borrar?id=${p.id}">Borrar persona</a>
				</td>
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
			<td>
				<a class="btn btn-primary" href="guardar">Guardar</a>
			</td>
		</tr>
	</tfoot>

</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
