<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto</title>
</head>
<body>

	<form action="producto" method="post">
		<div>
			<label for="id">Id</label> <input type="number" readonly name="id" value="${producto.id}" />
		</div>
		<div>
			<label for="nombre">Nombre</label> <input type="text" name="nombre" value="${producto.nombre}"/>
		</div>
		<div>
			<label for="precio">Precio</label> <input type="number" step=".01"
				name="precio" value="${producto.precio}" />
		</div>
		<div>
			<button>Aceptar</button>
		</div>
	</form>

</body>
</html>