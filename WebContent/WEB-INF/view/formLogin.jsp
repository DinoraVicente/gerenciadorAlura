<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:url value="/index" var="linkEntrada"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
	<form action="${linkEntrada}" method="POST">
		<label>Login:<input type="text" name="login" /></label>
		<label>Senha:<input type="password" name="password" /></label>
		<input type="hidden" name="action" value="Login" />
		<input type="submit" />
	</form>
</body>
</html>