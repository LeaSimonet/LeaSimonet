<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${erreur!=null}">
		<div>infos manquantes</div>
	</c:if>
	<form method="POST">
		prenom : <input name="prenom" value="${personne.prenom }"> <br>
		nom: <input name="nom" value="${personne.nom }"><br> rue:
		<input name="adresse.rue" value="${personne.adresse.rue}"><br>
		ville: <input name="adresse.ville" value="${personne.adresse<ville}"><br>

		<button type="submit">envoyer</button>
	</form>
</body>
</html>