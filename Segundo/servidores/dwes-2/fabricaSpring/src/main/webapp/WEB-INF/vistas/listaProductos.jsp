<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo lista productos</title>
</head>
<body>
	<header>
		<h1>Gestion de Productos</h1>
		<h3>Mensaje: ${ mensaje }</h3>
		<nav>
			<a href="/productos/alta">Alta producto</a>
			<a href="/productos">Listado productos</a>
		</nav>
	</header>
	<main>
		<h3>Listado de productos</h3>
		<table>
			<thead>
				<tr><th>Id</th><th>Descripci&oacute;n</th><th>Precio</th><th>Editar</th><th>Eliminar</th></tr>
			</thead>
			<tbody>
				<c:forEach var="prod" items="${ listaProductos }">
					<tr>
						<td>${ prod.idProducto }</td>
						<td>${ prod.descripcion }</td>
						<td>${ prod.precioUnitario }</td>
						<td><a href="/productos/editar/${prod.idProducto}">Editar</a></td>
						<td><a href="/productos/eliminar?idProducto=${prod.idProducto}">Eliminar</a></td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>