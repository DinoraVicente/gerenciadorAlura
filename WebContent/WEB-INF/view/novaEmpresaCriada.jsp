<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Empresa Cadastrada</title>
</head>
	<body>
		<c:if test="${not empty empresa}">
				<h3>Empresa ${empresa} cadastrada com sucesso</h3>
		</c:if>
		<c:if test="${empty empresa}">
				<h3>Nenhuma empresa cadastrada!</h3>
		</c:if>
	</body>
</html>