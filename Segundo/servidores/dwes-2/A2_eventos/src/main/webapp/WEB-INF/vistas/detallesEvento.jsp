<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
		<link href="<c:url value="/css/tablas.css" />" rel="stylesheet">
		<link href="<c:url value="/css/detallesEvento.css" />" rel="stylesheet">
	</head>
	<body>
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<li class="main-nav__item"><a href="#" a class="btn-link">Tipos</a></li>
					<li class="main-nav__item current-tab"><a class="btn-link" href="/eventos/todos">Eventos</a></li>
					<li class="main-nav__item"><a class="btn-link" href="#">Usuarios</a></li>
					<li class="main-nav__item"><a class="btn-link" href="/eventos/activos">Eventos/Tipo</a></li>
					<li class="main-nav__item"><a class="btn-link" href="/reservas/">${ idCliente ne null ? 'Mis ' : '' }Reservas</a></li>
					<li class="main-nav__item"><a class="btn-link"href=${ idCliente !=null ? "/clientes/cerrarSesion" : "/clientes/login" }>${ idCliente !=null ? "Salir" : "Login" }</a></li>
					<c:if test="${ idCliente eq null }">
						<li class="main-nav__item"><a class="btn-link" href="/clientes/registrar">Registrar</a></li>
					</c:if>		
				</ul>
			</nav>
		</header>
		  <main>
    		<h2>Detalles del evento #${ evento.idEvento }</h2>
   			<div class="columna-izquierda">
      			<table>
        			<tbody>
          				<tr><th>Nombre</th><td>${ evento.nombre }</td></tr>
          				<tr><th>Descripci&oacute;n</th><td>${ evento.descripcion }</td></tr>
          				<tr><th>Direcci&oacute;n</th><td>${ evento.direccion }</td></tr>
          				<tr><th>Fecha inicio (dd/mm/aaaa) </th><td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${evento.fechaInicio}" /></td></tr>
          				<tr><th>Duraci&oacute;n</th><td>${ evento.duracion }</td></tr>
          				<tr><th>Aforo m&aacute;ximo</th><td>${ evento.maxAforo }</td></tr>
          				<tr><th>M&iacute;nima asistencia</th><td>${ evento.minAsistencia }</td></tr>
        			</tbody>
      			</table>
    	</div>
    	<div class="columna-derecha">
    		<table>
        		<tbody>
          			<tr><th>Precio</th><td>${ evento.precio }&euro;</td></tr>
          			<tr><th>Plazas disponibles</th><td>${ plazasDisponibles }</td></tr>
        		</tbody>
      		</table>
     		<form action="/reservas/reservar/${ evento.idEvento }" method="post">		
        		<label for="cantidad">N&uacute;mero de entradas</label>
        		<input type="number" name="cantidad" id="cantidad" required min="1" max="10" value="1"><br>
        		<fieldset class="form__actions">
        			<c:choose>
        				<c:when test="${ editable }" >
        					<a class="btn-link cta" href="/eventos/editar/${ evento.idEvento }">Editar</a>	
						</c:when>
						<c:otherwise>
							<button type="submit" name="submit" id="submit" class="btn-link cta">Reservar</button>							
						</c:otherwise>
        			</c:choose>
        			<a class="btn-link" href="/eventos/activos">Volver al listado</a>
        		</fieldset>
      		</form>
      		<img src="<c:url value="/images/imagenEvento.jpg"/>" alt="">
    </div>
    <div class="feedback-usuario">
		<p class="mensaje-error">${ mensajeError }</p>
		<p class="mensaje-exito">${ mensajeExito }</p>
	</div>
  </main>
	</body>
</html>