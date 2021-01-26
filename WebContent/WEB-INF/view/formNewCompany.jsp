<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:url value="/index" var="linkEntrada"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro Empresa</title>
</head>
<body>
	<c:import url="logoutParcial.jsp" />

	<form action="${linkEntrada}" method="POST">
		<label>Nome:<input type="text" name="name" /></label>
		<label>Data de abertura:<input type="text" name="date" /></label>
		<input type="hidden" name="action" value="NewCompany" />
		<input type="submit" />
	</form>
</body>
</html>