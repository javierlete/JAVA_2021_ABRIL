<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>

	<form action="" method="post">
		<input type="email" name="email" placeholder="Email" />
		<input type="password" name="password" placeholder="Contraseña" />
		<button>Login</button>
		<span class="error">${param.error}</span>
	</form>	
</body>
</html>