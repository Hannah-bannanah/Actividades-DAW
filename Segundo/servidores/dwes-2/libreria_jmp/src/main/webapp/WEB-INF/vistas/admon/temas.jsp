<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Temas</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../compartido/header.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Temas</h1>
		<form action="/admon/altaTema" method="post">
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
			<fieldset class="full-form">
				<legend>Nuevo tema</legend>
			<fieldset class="flex-container">
				<fieldset class="flex-container">
					<label for="abreviatura">Abreviatura</label>
					<input type="text" name="abreviatura" id="abreviatura" required />
				</fieldset>		
				<fieldset class="flex-container">
					<label for="descTema">Nombre</label>
					<input type="text" name="descTema" id="descTema" required />
				</fieldset>	
				</fieldset>		
				<button type="submit" class="btn-link">Crear tema</button>
			</fieldset>
		</form>
		<table>
			<thead>
				<tr><th>ID</th><th>Abreviatura</th><th>Nombre</th>
			</thead>
			<tbody>
				<c:forEach var="tema" items="${ listaTemas }">
					<tr>
						<td>${ tema.idTema }</td>
						<td>${ tema.abreviatura }</td>
						<td>${ tema.descTema }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>