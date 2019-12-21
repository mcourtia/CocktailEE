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
		<div id="message"><c:out value="${message}"/></div>
		<div id="subtitle">Commande à préparer :</div>
		<ul>
			<li><i>Numéro de table :</i> <fmt:formatNumber value="${prepacommande.numTable}"/></li>
			<li><i>Cocktail :</i> <c:out value="${prepacommande.cocktail.nom}"/></li>
			<li><i>Composition :</i> <c:out value="${prepacommande.cocktail.composition}"/></li>
		</ul>
		<a href="/cocktailee/delete"><button>Cocktail prêt</button></a><br>
		<a href="/cocktailee/listecommandes"><button>Liste des commandes</button></a>
	</div>
</body>
</html>