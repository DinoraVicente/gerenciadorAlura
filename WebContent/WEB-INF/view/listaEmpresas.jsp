<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List,br.com.alura.gerenciador.model.Empresa" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada?action=CadastroEmpresa" var="linkCadastro"/>    
<c:url value="/entrada?action=MostraEmpresa" var="linkMostraEmpresa"/>
<c:url value="/entrada?action=RemoveEmpresa" var="linkRemoveEmpresa"/>

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
		<a href="${linkCadastro}">
			<h3>Cadastre sua empresa!</h3>
		</a>
		 
		<h2>Empresas cadastradas: </h2>
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>
					${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />
					<a href="${linkMostraEmpresa}&id=${empresa.id}">Editar</a>
					<a href="${linkRemoveEmpresa}&id=${empresa.id}">Remover empresa</a>
				</li>	
			</c:forEach>
		</ul>
	</body>
</html> 