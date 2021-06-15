<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="producto" method="post">
	<div>
		<label class="form-label" for="id">Id</label> <input class="form-control" type="number" readonly name="id"
			value="${producto.id}" />
	</div>
	<div>
		<label class="form-label" for="nombre">Nombre</label> <input class="form-control" type="text" name="nombre"
			value="${producto.nombre}" />
	</div>
	<div>
		<label class="form-label" for="precio">Precio</label> <input class="form-control" type="number" step=".01"
			name="precio" value="${producto.precio}" />
	</div>
	<div>
		<button class="btn btn-primary">Aceptar</button>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>