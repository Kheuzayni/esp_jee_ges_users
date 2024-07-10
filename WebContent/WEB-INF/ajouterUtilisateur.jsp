<%@page import="com.sun.javafx.css.Style"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="inc/entete.jsp"/>
	<jsp:include page="inc/menu.jsp"/>
	
	<form method="post">
		<fieldset>
			<legend  Style="text:center;" >Ajout d'un utilisateur</legend>
			<label>Nom</label>
			<input type="text" name="nom"><br>
			<label>Prénom</label>
			<input type="text" name="prenom"><br>
			<label>Login</label>
			<input type="text" name="login"><br>
			<label>Password</label>
			<input type="password" name="password"><br>
			<input type="submit" value="Ajouter">
		</fieldset>
	</form>
	<jsp:include page="inc/footer.jsp"/>
</body>
</html>