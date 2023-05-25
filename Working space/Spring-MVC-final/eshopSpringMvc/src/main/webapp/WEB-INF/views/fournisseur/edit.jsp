<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eshop</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styles.css">
<base href="${pageContext.request.contextPath }/">
</head>
<body>
	<div class="container"></div>
	<h1>Formulaire du fournisseur</h1>
	<form:form action="fournisseur/save" method="post"
		modelAttribute="fournisseur">
		<div class="form-group">
			<form:label path="id">Identifiant:</form:label>
			<form:input path="id" class="form-control" readonly="true"
				placeholder="Génération automatique" />
		</div>
		<div class="form-group">
			<form:label path="nom">Nom :</form:label>
			<form:input path="nom" class="form-control" />
			<form:errors path="nom">
				<div class="alert alert-danger">Le nom est obligatoire</div>
			</form:errors>
		</div>
		<div class="form-group">
			<form:label path="contact">contact:</form:label>
			<form:input path="contact" class="form-control" />
			<form:errors path="contact"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="adresse.numero">numero:</form:label>
			<form:input path="adresse.numero" class="form-control" />
		</div>
		<div class="form-group">
			<form:label path="adresse.rue">rue:</form:label>
			<form:input path="adresse.rue" class="form-control" />
		</div>
		<div class="form-group">
			<form:label path="adresse.codePostal">code postal:</form:label>
			<form:input path="adresse.codePostal" class="form-control" />
		</div>
		<div class="form-group">
			<form:label path="adresse.ville">ville:</form:label>
			<form:input path="adresse.ville" class="form-control" />
			<form:errors path="adresse.ville"></form:errors>
		</div>
		<div>
			<button type="submit" class="btn btn-primary">enregistrer</button>
			<a href="fournisseur" class="btn btn-link">annuler</a>
		</div>

	</form:form>
</body>
</html>