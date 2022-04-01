<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Buscar por t&iacute;tulo</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="./compartido/header.jsp"></jsp:include>	
		<main>
		<sec:csrfInput />
		<h1>Libros por titulo</h1>
		<form action="/cliente/buscar" method="post">
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
			<label for="titulo">Introduzca t&eacute;rmino de b&uacute;squeda</label>
			<input type="text" name="cadena" id="titulo" />
			<p>Dejar en blanco para ver todos los libros</p>
			<button type="submit" class="btn-link">Buscar</button>
		</form>
		<sec:authorize access="hasAuthority('ROL_ADMON')">
			<a class="btn-link" href="/admon/altaLibro">Nuevo libro</a>
		</sec:authorize>
		<c:if test="${ listaLibros ne null }">
			<jsp:include page="./compartido/tablaLibros.jsp"></jsp:include>	
		</c:if>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>