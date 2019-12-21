<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cocktail EE</title>
	<style><%@ include file="../style/style.css" %></style>
</head>
<body>
	<div id="content">
		<div class="title">Cocktail EE</div>
		<div id="subtitle">Récapitulatif de la commande :</div>
		<ul>
			<li><i>Numéro de table :</i> <fmt:formatNumber value="${commande.numTable}"/></li>
			<li><i>Cocktail :</i> <c:out value="${commande.cocktail.nom}"/></li>
			<li><i>Date et heure :</i> <c:out value="${commande.date}"/></li>
		</ul>
		<a href="/cocktailee/"><button>Retour à l'accueil</button></a>
	</div>
</body>
</html>