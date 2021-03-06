<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h1 class="display-1">Página principal</h1>

<div
	class="row row-cols-1 row-cols-md-2 row-cols-lg-3 row-cols-xl-4 row-cols-xxl-5 g-4">
	<c:forEach items="${personas}" var="p">
		<div class="col">
			<div class="card h-100">
				<img src="fotos/${p.id}.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">${p.nombre}${p.apellidos}</h5>
					<p class="card-text">${p.ocupacion.nombre}</p>
					<p class="card-text">
						<fmt:formatNumber type="currency" value="${p.sueldo}" />
					</p>
					<p class="card-text">${p.ocupacion.descripcion}</p>

				</div>
				<div class="card-footer">
					<a class="btn btn-primary w-100" href="agregar?id=${p.id}">Agregar
						a la bolsa</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
