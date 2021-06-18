<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/producto" method="post" novalidate>
	<div>
		<label class="form-label" for="id">Id</label> <input class="form-control" type="number" readonly name="id"
			value="${producto.id}" /> 
	</div>
	<div>
		<label class="form-label" for="nombre">Nombre</label> <input required class="form-control" type="text" name="nombre"
			value="${producto.nombre}" /> <span class="error">${producto.errores.nombre}</span>
	</div>
	<div>
		<label class="form-label" for="precio">Precio</label> <input required min="0" class="form-control" type="number" step=".01"
			name="precio" value="${producto.precio}" /> <span class="error">${producto.errores.precio}</span>
	</div>
	<div>
		<button class="btn btn-primary">Aceptar</button>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>