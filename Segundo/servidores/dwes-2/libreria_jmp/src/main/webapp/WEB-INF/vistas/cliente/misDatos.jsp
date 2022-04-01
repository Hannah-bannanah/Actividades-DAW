<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mis Datos</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/detalle.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../compartido/header.jsp"></jsp:include>		
		<main>
		<h1>Mis datos</h1>
		<table class="flex-container">
			<thead>
				<tr class="flex-container">
					<th>Username</th>
					<th>Email</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Direcci&oacute;n</th>
					<th>Fecha de alta</th>
					<th>Numero de temas</th>
					<th>Total libros</th>	
					<th>Total Compras</th>
				</tr>
			</thead>
			<tbody>
				<tr class="flex-container">
					<td>${ cliente.username }</td>
					<td>${ cliente.email }</td>
					<td>${ cliente.nombre }</td>
					<td>${ cliente.apellido }</td>
					<td>${ cliente.direccion ne null ? cliente.direccion: 'N/A' }</td>
					<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ cliente.fechaAlta }" /></td>
					<td>${ totalTemas }</td>
					<td>${ totalLibros }</td>				
					<td>${ totalCompras }&euro;</td>
				</tr>
			</tbody>
		</table>
		<h2> Mis pedidos</h2>
		<c:if test="${ listaPedidos ne null }">
		<table>
			<thead>
				<tr><th>Id Pedido</th><th>Fecha</th><th>Nombre cliente</th><th>Direccion</th>
			</thead>
			<tbody>
				<c:forEach var="pedido" items="${ listaPedidos }">
					<tr><td>${ pedido.idPedido }</td><td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ pedido.fechaAlta }" /></td><td>${ pedido.usuario.nombre }</td><td>${ pedido.direccionEntrega }</td>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>