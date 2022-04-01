<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Pedido #${ pedido.idPedido }</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/detalle.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../compartido/header.jsp"></jsp:include>		
		<main>
		<h1>Pedido #${ pedido.idPedido }</h1>
		<table class="flex-container">
			<thead>
				<tr class="flex-container">
					<th>ID Pedido</th>
					<th>Direcci&oacute;n</th>
					<th>Estado</th>
					<th>Fecha de alta</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<tr class="flex-container">
					<td>${ pedido.idPedido }</td>
					<td>${ pedido.direccionEntrega ne null ? pedido.direccionEntrega : 'N/A' }</td>
					<td>${ pedido.estado }</td>
					<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ pedido.fechaAlta }" /></td>
					<td>${ total }&euro;</td>
				</tr>
			</tbody>
		</table>
		<h2>Compra</h2>
		<table>
			<thead>
				<tr><th></th><th>T&iacute;tulo</th><th>Autor</th><th>Precio</th><th>Cantidad</th></tr>
			</thead>
			<tbody>
				<c:forEach var="linea" items="${ pedido.lineasPedidos }">
					<tr><td><img src="${ linea.libro.imagen }" /></td><td>${ linea.libro.titulo }</td><td>${ linea.libro.autor }</td>
					<td>${ linea.libro.precioUnitario }&euro;</td><td>${ linea.cantidad }</td></tr>
				</c:forEach>
			</tbody>
		</table>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>