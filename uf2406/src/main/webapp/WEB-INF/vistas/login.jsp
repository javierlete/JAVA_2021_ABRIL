<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="login" method="post">
	<div>
		<label class="form-label" for="email">Email</label> <input class="form-control" type="email" name="email"
			value="${usuario.email}" />
	</div>
	<div>
		<label class="form-label" for="password">Contraseña</label> <input class="form-control" type="password"
			name="password" value="${usuario.password}" />
	</div>
	<div>
		<button class="btn btn-primary">Iniciar sesión</button>
		<span class="error">${error}</span>
	</div>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>