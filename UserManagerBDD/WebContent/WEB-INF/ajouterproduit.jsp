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
		<h1 id="titre-principal">Ajout d'un Produit</h1>
		<form method="post">
			<fieldset>
				<legend>Ajout d'un Produit</legend>
				<div class="formItem">
					<label>Désignation</label>
					<input type="text" name="designation" value="${form.produit.designation}">
					<span class="erreur">${form.erreurs.nom}</span>
				</div>
				<div class="formItem">
					<label>Prix</label>
					<input type="text" name="prix" value="${form.produit.prix}">
					<span class="erreur">${form.erreurs.prix}</span>
				</div>
				<div class="formItem">
					<label>Quantite</label>
					<input type="text" name="quantite" value="${form.produit.quantite}">
					<span class="erreur">${form.erreurs.login}</span>
				</div>
				
				<div class="formItem">
					<input type="submit" value="Ajouter">
				</div>
			</fieldset>
			<c:if test="${ !empty form }">
				<br>
				<fieldset>
					<label class="${ empty form.erreurs ? 'succes' : 'erreur' }">${form.statusMessage}</label>
				</fieldset>
			</c:if>
		</form>
	</div>
	<jsp:include page="inc/pied.jsp"/>
</body>
</html>