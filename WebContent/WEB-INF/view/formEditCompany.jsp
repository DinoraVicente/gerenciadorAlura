<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<c:url value="/index" var="linkEntrada"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Editar dados da empresa</title>
</head>
<body>
	<c:import url="logoutParcial.jsp" />

	<form action="${linkEntrada}" method="POST">
		<label>Nome:<input type="text" name="name" value="${company.name}" /></label>
		<label>Data de abertura:<input type="text" name="date" value="<fmt:formatDate value="${company.openingDate}" pattern="dd/MM/yyyy" />"  /></label>
		<input type="hidden" name="id" value="${company.id}" />
		<input type="hidden" name="action" value="EditCompany" > 
		<input type="submit" />
	</form>
</body>
</html>