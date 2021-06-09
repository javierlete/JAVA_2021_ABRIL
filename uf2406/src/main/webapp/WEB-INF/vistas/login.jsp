<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<form action="login" method="post">
		<div>
			<label for="email">Email</label>
			<input type="email" name="email" value="${usuario.email}" />
		</div>
		<div>
			<label for="password">Contraseña</label>
			<input type="password" name="password" value="${usuario.password}" />
		</div>
		<div>
			<button>Iniciar sesión</button>
			<span class="error">${error}</span>
		</div>
	</form>
</body>
</html>