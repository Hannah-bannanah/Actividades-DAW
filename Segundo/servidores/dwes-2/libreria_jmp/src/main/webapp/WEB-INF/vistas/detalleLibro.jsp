<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ libro.titulo }</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/detalle.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="./compartido/header.jsp"></jsp:include>
		<main>
		<h1>${ libro.titulo }</h1>
		<section class="flex-container">
		<img src="${ libro.imagen }" />
		<table class="flex-container">
			<thead>
				<tr class="flex-container">
					<th>ISBN</th>
					<th>T&iacute;tulo</th>
					<th>Autor</th>
					<th>Precio</th>
					<th>Tema</th>
					<th>P&aacute;ginas</th>
					<th>Novedad</th>
				</tr>
			</thead>
			<tbody>
				<tr class="flex-container">
					<td>${ libro.isbn }</td>
					<td>${ libro.titulo }</td>
					<td>${ libro.autor }</td>
					<td>${ libro.precioUnitario }&euro;</td>
					<td>${ libro.tema.descTema }</td>
					<td>${ libro.paginas }</td>
					<td>${ libro.novedad }</td>
				</tr>
			</tbody>
		</table>
		</section>
		<sec:authorize access="hasAuthority('ROL_CLIENTE')">
			<a class="btn-link" href="/carrito/anadir/${ libro.isbn }">A&ntilde;adir al carrito</a>
		</sec:authorize>
		<sec:authorize access="hasAuthority('ROL_ADMON')">
			<a class="btn-link" href="/admon/editar/${ libro.isbn }">Editar</a>
		</sec:authorize>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>