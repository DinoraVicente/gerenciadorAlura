<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List,br.com.alura.gerenciador.model.Company" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/index?action=RegisterCompany" var="linkRegister"/>    
<c:url value="/index?action=SearchCompany" var="linkSearchCompany"/>
<c:url value="/index?action=RemoveCompany" var="linkRemoveCompany"/>
<c:url value="/index?action=Logout" var="linkLogout"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
	<body>
		<c:import url="logoutParcial.jsp" />
	
		<c:if test="${not empty company}">
				<h3>Empresa ${company} cadastrada com sucesso</h3>
		</c:if>
		<a href="${linkRegister}">
			<h3>Cadastre sua empresa!</h3>
		</a>
		 
		<h2>Empresas cadastradas: </h2>
		<ul>
			<c:forEach items="${companyList}" var="company">
				<li>
					${company.name} - <fmt:formatDate value="${company.openingDate}" pattern="dd/MM/yyyy" />
					<a href="${linkSearchCompany}&id=${company.id}">Editar</a>
					<a href="${linkRemoveCompany}&id=${company.id}">Remover empresa</a>
				</li>	
			</c:forEach>
		</ul>
	</body>
</html> 