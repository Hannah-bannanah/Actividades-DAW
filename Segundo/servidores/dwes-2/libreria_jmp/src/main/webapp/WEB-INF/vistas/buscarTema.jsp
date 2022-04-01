<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Buscar por tema</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="./compartido/header.jsp"></jsp:include>		
		<main>
		<sec:csrfInput />
		<h1>Buscar por tema</h1>
		<form action="/cliente/tema" method="post">
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
			<label for="tema">Seleccionar tema</label>
			<select name="tema" id="tema" required>
				<option value="">Tema</option>
				<c:forEach var="t" items="${ listaTemas }">
					<option value="${ t.idTema }">${ t.descTema }</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn-link">Buscar</button>
		</form>
		<c:if test="${ listaLibros ne null }">
			<jsp:include page="./compartido/tablaLibros.jsp"></jsp:include>		
		</c:if>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>