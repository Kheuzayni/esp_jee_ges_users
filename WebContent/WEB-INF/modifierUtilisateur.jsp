<%@page import="sn.esp.m2glsi.beans.Utilisateurs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Utilisateurs user = (Utilisateurs) request.getAttribute("user");
%>
	<jsp:include page="inc/entete.jsp"/>
	<jsp:include page="inc/menu.jsp"/>
	<jsp:include page="inc/footer.jsp"/>
	<form method="post">
		<fieldset>
			<legend>modification  d'un utilisateur</legend>
			<input type="hidden" name="nom" value="${user.id}"><br>		
			<label>Nom</label>
			<input type="text" name="nom" value="${user.nom}"><br>
			<label>Prénom</label>
			<input type="text" name="prenom"  value="${user.prenom}"><br>
			<label>Login</label>
			<input type="text" name="login" value="${user.login}"><br>
			<label>Password</label>
			<input type="password" name="password" value="${user.password}" %>><br>
			<input type="submit" value="Ajouter">
		</fieldset>
	</form>
</body>
</html>