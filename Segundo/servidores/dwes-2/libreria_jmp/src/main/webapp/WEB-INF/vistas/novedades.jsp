<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Novedades</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="./compartido/header.jsp"></jsp:include>
		<main>
		<h1>Bienvenido <sec:authorize access="isAuthenticated()"><sec:authentication property="name"/></sec:authorize></h1>
		<h2>Novedades</h2>
		<sec:authorize access="hasAuthority('ROL_ADMON')">
			<a class="btn-link" href="/admon/altaLibro">Nuevo Libro</a>
		</sec:authorize>
		<jsp:include page="./compartido/tablaLibros.jsp"></jsp:include>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>