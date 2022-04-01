<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="./compartido/header.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Login</h1>
		<form action="/login" method="post">
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
			<fieldset class="full-form">
				<legend>Introduzca sus datos</legend>
				<fieldset class="flex-container">
					<fieldset class="flex-container">
						<label for="username">Username</label>
						<input type="text" name="username" id="username" required />
						<label for="password">Contrase&ntilde;a</label>
						<input type="password" name="password" id="password" required />		
					</fieldset>		

				</fieldset>		
				<button type="submit" class="btn-link">Login</button>
			</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>