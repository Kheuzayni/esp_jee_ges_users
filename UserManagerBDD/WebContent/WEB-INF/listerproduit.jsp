<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Accueil</title>
	<link rel="stylesheet" href="<c:url value='/css/design.css'/>">
</head>
<body>
	<jsp:include page="inc/entete.jsp"/>
	<jsp:include page="inc/menu.jsp"/>
	<div id="corps">
		<h1 id="titre-principal">Liste des Produits</h1>
		<c:choose>
			<c:when test="${ empty produits }">
				<p>Aucun Produit n'a pour le moment été ajouté</p>
			</c:when>
			<c:otherwise>
				<table>
				<tr>
					<th>ID</th>
					<th>Désignation</th>
					<th>Prix</th>
					<th>Quantité</th>
					
					<th colspan="2">Actions</th>
				</tr>
				<c:forEach items="${ produits }" var="produit">
					<tr>
						<td><c:out value="${ produit.id }"/></td>
						<td><c:out value="${ produit.designation }"/></td>
						<td><c:out value="${ produit.prix }"/></td>
						<td><c:out value="${ produit.quantite }"/></td>
						<td><a href="update?id=${ produit.id }">Modifier</a></td>
						<td><a href="delete?id=${ produit.id }">Supprimer</a></td>
					</tr>
				</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="inc/pied.jsp"/>
</body>
</html>