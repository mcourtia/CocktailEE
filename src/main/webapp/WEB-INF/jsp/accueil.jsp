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
	  	<a href="<c:url value="/commande"/>"><button>Commander</button></a><br>
	  	<a href="<c:url value="/listecommandes"/>"><button>Liste des commandes</button></a>
  	</div>
  </body>
</html>