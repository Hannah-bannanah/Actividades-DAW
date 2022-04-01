<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mi Carrito</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../compartido/header.jsp"></jsp:include>	
		<main>
		<h1>Mi Carrito</h1>
		<a class="btn-link" href="/">Volver</a>
		<c:if test="${ carrito ne null }">
		<table>
			<thead>
				<tr><th>T&iacute;tulo</th><th>Autor</th><th>Precio</th><th>Cantidad</th><th class="buffer-cell"></th><th>Eliminar</tr>
			</thead>
			<tbody>
				<c:forEach var="linea" items="${ carrito }">	
					<tr><td>${ linea.libro.titulo }</td><td>${ linea.libro.autor }</td><td>${ linea.libro.precioUnitario }</td><td>${ linea.cantidad }</td><td class="buffer-cell"></td>
					<td><a href="/carrito/eliminar/${ linea.libro.isbn }">Eliminar</a></td></tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<a class="btn-link" href="/carrito/realizarPedido">Comprar</a>
		
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>