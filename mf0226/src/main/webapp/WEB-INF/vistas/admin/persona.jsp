<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<form action="admin/persona" method="post">
	<input type="hidden" name="id" value="${persona.id}" />
	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text"
				class="form-control ${persona.errores.nombre != null ? 'is-invalid' : persona.errores.size() > 0 ? 'is-valid': ''}"
				id="nombre" name="nombre" value="${persona.nombre}">
			<div class="valid-feedback">El nombre es correcto</div>
			<div class="invalid-feedback">${persona.errores.nombre}</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="apellidos" class="col-sm-2 col-form-label">Apellidos</label>
		<div class="col-sm-10">
			<input type="text"
				class="form-control ${persona.errores.apellidos != null ? 'is-invalid' : persona.errores.size() > 0 ? 'is-valid': ''}"
				id="apellidos" name="apellidos" value="${persona.apellidos}">
			<div class="valid-feedback">Los apellidos son correctos</div>
			<div class="invalid-feedback">${persona.errores.apellidos}</div>
		</div>
	</div>
	
	<div class="row mb-3">
		<label for="ocupacion" class="col-sm-2 col-form-label">Ocupacion</label>
		<div class="col-sm-10">
			<select class="form-select" name="ocupacion" id="ocupacion">
				<c:forEach items="${ocupaciones}" var="o">
					<option value="${o.id}" ${o.id == persona.ocupacion.id ? 'selected' : '' }>${o.nombre}</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="row mb-3">
		<div class="offset-sm-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
		</div>
	</div>


</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
