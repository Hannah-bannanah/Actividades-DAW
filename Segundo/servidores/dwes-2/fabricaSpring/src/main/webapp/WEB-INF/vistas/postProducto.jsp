<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<header>
			<h1>Gestion de productos</h1>
			<h3>Mensaje ${ mensaje }</h3>
		</header>
		<main>
			<form action="${ empty producto ? '/productos/alta' : '/productos/editar/' }${ producto.idProducto }" method="post">
				<fieldset>
					<legend>${ empty producto ? 'Alta producto' : 'Editar producto #'}${ producto.idProducto }</legend>
					<label for="descripcion">Descripci&oacute;n</label><br>
					<input type="text" name="descripcion" id="descripcion" value="${ producto.descripcion }" required><br>
					<label for="precioUnitario">Precio</label><br>
					<input type="number" step="0.01" name="precioUnitario" id="precioUnitario" value="${ producto.precioUnitario }"required><br>
					<label for="familia.idFamilia">Familia</label>
					<select name="familia.idFamilia" id="familia" required>
						<option value="">Seleccione una familia</option>
						<c:forEach var="familia" items="${ familias }">
							<c:choose>
								<c:when test="${ producto.familia.idFamilia eq familia.idFamilia }">
									<option value="${ familia.idFamilia }" selected>${ familia.descripcion }</option>
								</c:when>
								<c:otherwise>
									<option value="${ familia.idFamilia }">${ familia.descripcion }</option>
								</c:otherwise>
							</c:choose>
							
						</c:forEach>
					</select>
					<fieldset id="form-actions">
						<c:if test="${ not empty producto }">
							<input type="text" hidden name="idProducto" value="${ producto.idProducto }">
							<input type="date" hidden name="fechaAlta" value=${ producto.fechaAlta }>
						</c:if>
						<button type="submit" name="submit" id="submit">Enviar</button>
						<button type="reset">Anular cambios</button>
					</fieldset>				
				</fieldset>
			</form>
		</main>
	</body>
</html>