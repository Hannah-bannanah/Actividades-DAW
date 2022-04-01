<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Detalles ${ cliente.username }</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/detalle.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../compartido/header.jsp"></jsp:include>
		<main>		
		<h1>Cliente: ${ cliente.username }</h1>
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
					<td>${ cliente.direccion ne null ? cliente.direccion : 'N/A' }</td>
					<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ cliente.fechaAlta }" /></td>
					<td>${ totalTemas }</td>
					<td>${ totalLibros }</td>				
					<td>${ totalCompras }&euro;</td>
				</tr>
			</tbody>
		</table>
		<table>
			<thead>
				<tr><th>Tema</th><th>Cantidad de libros comprados</th></tr>
			</thead>
			<tbody>
				<c:forEach var="entry" items="${ mapaTemas }">
					<tr><td>${ entry.key.descTema }</td><td>${ entry.value }</td></tr>
				</c:forEach>
			</tbody>
		</table>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>