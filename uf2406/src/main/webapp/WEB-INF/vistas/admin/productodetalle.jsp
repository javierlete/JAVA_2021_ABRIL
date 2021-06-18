<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="admin/producto" method="post" novalidate>
	<div>
		<label class="form-label" for="id">Id</label> <input class="form-control" type="number" readonly name="id"
			value="${producto.id}" /> 
	</div>
	<div>
		<label class="form-label" for="nombre">Nombre</label> <input required class="form-control ${producto.errores.nombre != null ? 'is-invalid' : ''}" type="text" name="nombre"
			value="${producto.nombre}" /> <div class="invalid-feedback">${producto.errores.nombre}</div>
	</div>
	<div>
		<label class="form-label" for="precio">Precio</label> <input required min="0" class="form-control ${producto.errores.precio != null ? 'is-invalid' : ''}" type="number" step=".01"
			name="precio" value="${producto.precio}" /> <div class="invalid-feedback">${producto.errores.precio}</div>
	</div>
	<div>
		<button class="btn btn-primary">Aceptar</button>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>