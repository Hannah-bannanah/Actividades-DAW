<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Movimientos</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
  		<link href='<c:url value="/css/table.css" />' rel="stylesheet">
	</head>
	<body>
		<main>
			<h1>Movimientos</h1>
			<h2>Cuenta: ${ cuenta.idCuenta }</h2>
			<a href="/cliente" class="btn-link">Volver al menu</a>
			<h2 class="saldo">Saldo: ${ cuenta.saldo }</h2>
			<table>
				<thead>
					<tr><th>Cantidad</th><th>Tipo</th><th>Fecha</th></tr>
				</thead>
				<tbody>
					<c:forEach var="movimiento" items="${ listaMovimientos }">
						<!-- <tr class="${ movimiento.operacion eq 'abono' ? 'ingreso' : 'extraccion' }">  -->
						<tr class="${fn:startsWith(movimiento.operacion, 'abono') ? 'ingreso' : 'extraccion' }">
							<td>${ movimiento.cantidad }</td>
							<td>${ movimiento.operacion }</td>
							<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ movimiento.fecha }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/cliente" class="btn-link">Volver al menu</a>
		</main>
	</body>
</html>