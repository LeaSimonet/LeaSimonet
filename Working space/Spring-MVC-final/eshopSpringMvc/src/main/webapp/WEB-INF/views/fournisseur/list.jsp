<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="container">
		<h1>Liste des fournisseurs</h1>
		<c:if test="${param['delete']!=null }">
			<div class="alert alert-warning small">Suppression du
				fournisseur ${param['delete']}</div>
		</c:if>
		<c:if test="${param['create']!=null}">
			<div class="alert alert-success small">Creation du fournisseur
				${param['create']}</div>
		</c:if>
		<c:if test="${param['update']!=null}">
			<div class="alert alert-success small">Mise à jour du
				fournisseur ${param['update']}</div>
		</c:if>
		<table class="table">
			<tr>
				<th>id:</th>
				<th>Nom:</th>
				<th>Contact:</th>
				<th>Adresse:</th>
				<th>Code postal:</th>
				<th>Ville:</th>
			</tr>
			<c:forEach var="f" items="${fournisseurs }">
				<tr>
					<th>${f.id }</th>
					<th>${f.nom }</th>
					<th>${f.contact }</th>
					<th>${f.adresse.numero }&nbsp;&${f.adresse.rue }</th>
					<th>${f.adresse.codePostal }</th>
					<th>${f.adresse.ville }</th>
					<td><a href="fournisseur/edit?id=${f.id }"
						class="btn btn-primary"> Editer</a></td>
					<td><a href="fournisseur/delete?id=${f.id }"
						class="btn btn-danger"> Supprimer</a></td>

				</tr>
			</c:forEach>
		</table>
		<a href="fournisseur/add" class="btn btn-link"> Nouveau
			fournisseur</a>
	</div>

</body>
</html>