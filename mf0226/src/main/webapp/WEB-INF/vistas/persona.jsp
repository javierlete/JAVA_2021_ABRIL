<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<form action="admin/persona" method="post">
	<input type="hidden" name="id" value="${persona.id}" />
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre" name="nombre" value="${persona.nombre}">
		</div>
	</div>
	<div class="row mb-3">
		<label for="apellidos" class="col-sm-2 col-form-label">Apellidos</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="apellidos" name="apellidos" value="${persona.apellidos}">
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>
	
	
</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
