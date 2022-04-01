<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ libro ne null ? 'Editar' : 'Alta' } libro</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../compartido/header.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>${ libro ne null ? 'Editar' : 'Nuevo' } Libro</h1>
		<a class="btn-link" href="/">Volver</a>
		<c:choose>
			<c:when test="${ libro ne null }" >
				<form action="/admon/editar/${ libro.isbn }" method="post">
			</c:when>
			<c:otherwise>
				<form action="/admon/altaLibro" method="post">
			</c:otherwise>
        </c:choose>	
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
			<fieldset class="full-form">
				<legend>${ libro ne null ? 'Editar' : 'Nuevo' } Libro</legend>
			<fieldset class="flex-container">
				<fieldset class="flex-container">
					<label for="isbn">ISBN</label>
					<input type="text" name="isbn" id="isbn" required
						value="${ libro ne null ? libro.isbn : '' }"/>
					<label for="imagen">Url imagen</label>
					<input type="text" name="imagen" id="imagen" value="${ libro ne null ? libro.imagen : '' }"/>
				</fieldset>		
				<fieldset class="flex-container">
					<label for="titulo">T&iacute;tulo</label>
					<input type="text" name="titulo" id="titulo" required value="${ libro ne null ? libro.titulo : '' }" />
					<label for="autor">Autor</label>
					<input type="text" name="autor" id="autor" value="${ libro ne null ? libro.autor : '' }" required />
				</fieldset>	
				<fieldset class="flex-container">
					<label for="paginas">N&uacute;mero de p&aacute;ginas</label>
					<input type="number" name="paginas" id="paginas" value="${ libro ne null ? libro.paginas : '0' }"/>
					<label for="tema">Tema</label>
					<select name="tema.idTema" id="tema" required>
						<option value="">Seleccionar tema</option>
						<c:forEach var="t" items="${ listaTemas }">
							<c:choose>
								<c:when test="${ libro ne null && t.idTema eq libro.tema.idTema }" >
									<option value="${ t.idTema }" selected>${ t.descTema }</option>		
								</c:when>
								<c:otherwise>
									<option value="${ t.idTema }">${ t.descTema }</option>							
								</c:otherwise>
        					</c:choose>			
						</c:forEach>
					</select>
				</fieldset>	
				<fieldset>
					<label for="precioUnitario">Precio</label>
					<input type="number" name="precioUnitario" id="precioUnitario" step="0.01" min="0.00"
						value="${ libro ne null ? libro.precioUnitario : '' }" />
					<label for="novedad">Novedad</label>
					<c:choose>
						<c:when test="${ libro ne null && libro.novedad eq 's'}" >
							<input type="checkbox" name="novedad" id="novedad" value="s" checked>
						</c:when>
						<c:when test="${ libro eq null}" >
							<input type="checkbox" name="novedad" id="novedad" value="s" checked>
						</c:when>
						<c:otherwise>
							<input type="checkbox" name="novedad" id="novedad" value="s">
						</c:otherwise>
					</c:choose>
				</fieldset>
				</fieldset>		
				<button type="submit" class="btn-link">${ libro ne null ? 'Actualizar' : 'Crear' } libro</button>
			</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>