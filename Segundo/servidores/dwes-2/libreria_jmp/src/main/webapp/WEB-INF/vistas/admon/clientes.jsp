<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Clientes</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../compartido/header.jsp"></jsp:include>	
		<main>	
		<h1>Clientes</h1>
		<c:if test="${ listaClientes ne null }">
		<table>
			<thead>
				<tr><th>Username</th><th>Email</th><th>Nombre</th><th>Apellido</th><th class="buffer-cell"></th><th>Ver Detalle</th></tr>
			</thead>
			<tbody>
				<c:forEach var="cliente" items="${ listaClientes }">
					<tr><td>${ cliente.username }</td><td>${ cliente.email }</td><td>${ cliente.nombre }</td><td>${ cliente.apellido }</td>
					<td class="buffer-cell"></td><td><a href="/admon/clientes/${ cliente.username }">Ver detalle</a></td></tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>