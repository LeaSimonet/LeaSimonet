<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1>inscription</h1>
	<% if(request.getAttribute("erreur")!=null){ %>
		<div class="alert alert-danger">
			informations manquantes
		</div>
	<%} %>
		<form action="inscription" method="post">
			<div class="form-group">
				<label for="prenom">prenom:</label> <input id="prenom" name="prenom"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="nom">nom:</label> <input id="nom" name="nom"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="login">login:</label> <input id="login" name="login"
					class="form-control">
			</div>
			<div>
				<button type="submit" class="btn btn-primary">envoyer</button>
			</div>
		</form>
	</div>
</body>
</html>