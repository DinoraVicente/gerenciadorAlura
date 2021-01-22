<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<c:url value="/removeEmpresa" var="linkServletRemoveEmpresa"/>
<c:url value="/mostraEmpresa" var="linkServletAltera"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
	<body>
		<c:if test="${not empty empresa}">
				<h3>Empresa ${empresa} cadastrada com sucesso</h3>
		</c:if>
		<h2>Empresas cadastradas: </h2>
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>
					${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />
					<a href="${linkServletAltera }?id=${empresa.id}">Editar</a>
					<a href="${linkServletRemoveEmpresa}?id=${empresa.id}">Remover empresa</a>
				</li>	
			</c:forEach>
		</ul>
	</body>
</html> 