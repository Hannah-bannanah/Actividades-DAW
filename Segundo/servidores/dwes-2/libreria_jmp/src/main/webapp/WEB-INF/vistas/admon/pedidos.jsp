<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Pedidos</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../compartido/header.jsp"></jsp:include>		
		<main>
		<h1>Pedidos</h1>
		<c:if test="${ listaPedidos ne null }">
		<table>
			<thead>
				<tr><th>Id Pedido</th><th>Fecha</th><th>Nombre cliente</th><th>Direccion</th><th class="buffer-cell"></th><th>Ver Detalle</th></tr>
			</thead>
			<tbody>
				<c:forEach var="pedido" items="${ listaPedidos }">
					<tr><td>${ pedido.idPedido }</td><td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ pedido.fechaAlta }" /></td><td>${ pedido.usuario.nombre }</td><td>${ pedido.direccionEntrega }</td>
					<td class="buffer-cell"></td><td><a href="/admon/pedidos/${ pedido.idPedido }">Ver detalle</a></td></tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>