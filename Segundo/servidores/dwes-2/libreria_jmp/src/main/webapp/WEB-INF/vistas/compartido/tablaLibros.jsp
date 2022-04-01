<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
	</head>
	<body>
		<table>
			<thead>
				<tr><th></th><th>T&iacute;tulo</th><th>Autor</th><th>Precio</th><th class="buffer-cell"></th>
				<sec:authorize access="isAuthenticated()">
					<th colspan="10">Opciones</th></tr>
				</sec:authorize>
			</thead>
			<tbody>
				<c:forEach var="libro" items="${ listaLibros }">
					<tr>
						<td><img src="${ libro.imagen }" /></td>
						<td>${ libro.titulo }</td>
						<td>${ libro.autor }</td>
						<td>${ libro.precioUnitario }</td>
						<td class="buffer-cell"></td>
						<sec:authorize access="isAuthenticated()">
							<td><a href="/cliente/verDetalle/${ libro.isbn }">Ver detalle</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('ROL_CLIENTE')">
							<td><a href="/carrito/anadir/${ libro.isbn }">A&ntilde;adir al carrito</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('ROL_ADMON')">
							<td><a href="/admon/editar/${ libro.isbn }">Editar</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('ROL_ADMON')">
							<td><a href="/admon/eliminar/${ libro.isbn }">Eliminar</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>