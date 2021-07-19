<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personal</title>

<base href="${pageContext.request.contextPath}/" />

<link href="css/bootstrap.min.css" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Personal</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Principal</a></li>
					<li class="nav-item"><a class="nav-link" href="admin">Admin</a></li>
				</ul>
				<span class="navbar-text">${sessionScope.usuario.email}</span>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<c:choose>
						<c:when test="${sessionScope.usuario == null}">
							<li class="nav-item"><a class="nav-link" aria-current="page"
								href="login">Inicio de sesión</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="logout">Salir</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	<c:if test="${textoMensaje != null}">
		<div class="alert alert-${tipoMensaje} alert-dismissible fade show"
			role="alert">
			${textoMensaje}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
		
		<% 
		session.removeAttribute("textoMensaje");
		session.removeAttribute("tipoMensaje");
		%>
	</c:if>
	<main class="container">