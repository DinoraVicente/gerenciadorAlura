<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<c:url value="/index?action=Logout" var="linkLogout"/>

<a href="${linkLogout}"><h4>Sair</h4></a>
<h4>Usu�rio Logado: ${userLogged.login}</h4>