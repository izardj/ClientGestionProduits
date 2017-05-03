<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un produit</title>
</head>
<body>
	<ul>
		<li><a href="ListerProduits">Lister produits</a></li>
		<li><a href="index.jsp">Ajouter produit</a></li>
	</ul>
	<h2>Ajouter un produit</h2>
	<form method="post" action="AjouterProduit">

		<label for="nom">Nom</label>
		<input type="text" name="nom" id="nom" required /><br/>
		<label for="quantite">Quantité</label>
		<input type="text" name="quantite" id="quantite" required /><br/>
		<label for="prix">Prix</label>
		<input type="text" name="prix" id="prix" required /><br/>
		<button type="submit">Ajouter</button>
	</form>
</body>
</html>