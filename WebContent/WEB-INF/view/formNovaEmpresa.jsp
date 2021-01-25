<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:url value="/entrada" var="linkEntrada"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro Empresa</title>
</head>
<body>
	<form action="${linkEntrada}" method="POST">
		<label>Nome:<input type="text" name="nome" /></label>
		<label>Data de abertura:<input type="text" name="data" /></label>
		<input type="hidden" name="action" value="NovaEmpresa" />
		<input type="submit" />
	</form>
</body>
</html>