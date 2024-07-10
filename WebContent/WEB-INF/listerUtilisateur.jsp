<%@page import="sn.esp.m2glsi.beans.Utilisateurs"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des utilisateurs</title>
</head>
<body>
	<jsp:include page="inc/entete.jsp"/>
	<jsp:include page="inc/menu.jsp"/>
	
	<%
		ArrayList<Utilisateurs> utilisateurs = (ArrayList<Utilisateurs>) request.getAttribute("utilisateurs");
		if(utilisateurs.isEmpty())
		{%>
			<p>Aucun utilisateur n'a pour le moment été ajouté</p><%
		}
		else
		{%>
			<table border="1" cellspacing="0" cellpadding="2">
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Login</th>
					<th>Password</th>
					<th colspan="2">Actions</th>
				</tr><%
				for (Utilisateurs utilisateur : utilisateurs)
				{%>
					<tr>
						<td><%= utilisateur.getId() %></td>
						<td><%= utilisateur.getNom() %></td>
						<td><%= utilisateur.getPrenom() %></td>
						<td><%= utilisateur.getLogin() %></td>
						<td><%= utilisateur.getPassword() %></td>
						<td><a href="update?id=<%= utilisateur.getId() %>">Modifier</a></td>
						<td><a href="delete?id=<%= utilisateur.getId() %>">Supprimer</a></td>
					</tr><%
				}%>
			</table><%
		}
	%>
	<jsp:include page="inc/footer.jsp"/>
</body>
</html>