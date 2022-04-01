<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Usuarios</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../compartido/header.jsp"></jsp:include>		
		<main>
		<h1>Usuarios</h1>
		<a class="btn-link" href="/admon/altaUsuario">Nuevo Usuario</a>
		<c:if test="${ listaUsuarios ne null }">
		<table>
			<thead>
				<tr><th>Username</th><th>Email</th><th>Nombre</th><th>Apellido</th><th>Roles</th>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${ listaUsuarios }">
					<tr><td>${ usuario.username }</td><td>${ usuario.email }</td><td>${ usuario.nombre }</td><td>${ usuario.apellido }</td>
					<td>
						<c:forEach var="perfil" items="${ usuario.perfiles }">
							${ perfil.descripcion } 
						</c:forEach>
					</td></tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>