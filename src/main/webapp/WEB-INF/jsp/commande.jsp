<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	  	
		<form method="post" accept-charset="utf-8">
			<div>
				<select id="cocktail" name="cocktail">
					<option value="0">-- Cocktail --</option>
					<c:forEach var="cocktail" items="${listeCocktails}">
						<option value="${cocktail.id}" ${param['cocktail'] == cocktail.id ? "selected" : ""}>
							<c:out value="${cocktail.nom}"/>
						</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<input id="table" name="table" type="text" placeholder="Table n°" value="<c:out value="${param['table']}" />"> 
			</div>
			<button type="submit">Ajouter Commande</button>
		</form>
		<a href="<c:url value="/"/>"><button>Retour à l'accueil</button></a>
  	</div>
  </body>
</html>