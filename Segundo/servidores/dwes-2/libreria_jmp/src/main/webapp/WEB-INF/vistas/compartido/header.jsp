<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<sec:csrfInput />
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<sec:authorize access="!isAuthenticated()">
						<li class="main-nav__item"><a href="/" class="btn-link">Inicio</a></li>				
					</sec:authorize>
					<sec:authorize access="hasAuthority('ROL_ADMON')">
						<li class="main-nav__item"><a href="/admon/usuarios" class="btn-link">Usuarios</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/admon/perfiles">Perfiles</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/admon/clientes">Clientes</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/admon/pedidos">Pedidos</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/admon/temas">Temas</a></li>
					</sec:authorize>	
					<sec:authorize access="hasAnyAuthority('ROL_ADMON','ROL_CLIENTE')">						
						<li class="main-nav__item"><a class="btn-link" href="/cliente/tema">Buscar por tema</a></li>						
						<li class="main-nav__item"><a class="btn-link" href="/cliente/buscar">Libros (buscar)</a></li>					
						<li class="main-nav__item"><a class="btn-link" href="/novedades">Novedades</a></li>
					</sec:authorize>
					<sec:authorize access="hasAuthority('ROL_CLIENTE')">
						<li class="main-nav__item"><a class="btn-link" href="/cliente/misDatos">Mis Datos</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/carrito/verCarrito">Carrito</a></li>		
					</sec:authorize>	
					<sec:authorize access="!isAuthenticated()">
						<li class="main-nav__item"><a href="/login" class="btn-link">Log in</a></li>	
						<li class="main-nav__item"><a href="/alta" class="btn-link">Registro</a></li>		
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">	
						<li class="main-nav__item"><a class="btn-link danger" href="/logout">Salir</a></li> 
					</sec:authorize>
				</ul>
			</nav>
		</header>
</body>
</html>