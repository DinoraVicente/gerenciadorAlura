<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro Empresa</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="POST">
		<label>Nome:<input type="text" name="nome" /></label>
		<label>Data de abertura:<input type="text" name="data" /></label>
		<input type="submit" />
	</form>
</body>
</html>