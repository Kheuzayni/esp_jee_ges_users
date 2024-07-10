<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();

%>
<ul>
	<li><a href="<%= path %>">Accueil</a></li>
	<li><a href="<%= path %>/users/add">Ajouter</a></li>
	<li><a href="<%= path %>/users/list">Lister</a></li>
</ul>
<hr>