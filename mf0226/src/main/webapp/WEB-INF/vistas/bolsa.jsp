<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>${bolsa.empresa}</h2>

<ul>
	<c:forEach items="${bolsa.personas}" var="p">
		<li>${p}</li>
	</c:forEach>
</ul>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
