<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Perfiles</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../compartido/header.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Perfiles</h1>
		<form action="/admon/altaPerfil" method="post">
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
			<fieldset class="full-form">
				<legend>Nuevo perfil</legend>
			<fieldset class="flex-container">	
				<fieldset class="flex-container">
					<label for="descripcion">Nombre</label>
					<input type="text" name="descripcion" id="descripcion" required />
				</fieldset>	
				</fieldset>		
				<button type="submit" class="btn-link">Crear Perfil</button>
			</fieldset>
		</form>
		<table>
			<thead>
				<tr><th>ID</th><th>Nombre</th>
			</thead>
			<tbody>
				<c:forEach var="perfil" items="${ listaPerfiles }">
					<tr>
						<td>${ perfil.idPerfil }</td>
						<td>${ perfil.descripcion }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>