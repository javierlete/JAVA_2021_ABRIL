<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList,com.ipartek.formacion.uf2406.modelos.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
	</thead>
	<tbody>
		<% 
		ArrayList<Producto> productos = (ArrayList<Producto>)request.getAttribute("productos");
		for(Producto producto: productos) { 
		%>
		<tr>
			<th><%=producto.getId() %></th>
			<td><%=producto.getNombre() %></td>
			<td><%=producto.getPrecio() %></td>
		</tr>
		<% } %>
	</tbody>
</table>

</body>
</html>