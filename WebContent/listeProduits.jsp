<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des produits</title>
</head>
<body>
	<ul>
		<li><a href="ListerProduits">Lister produits</a></li>
		<li><a href="index.jsp">Ajouter produit</a></li>
	</ul>
<h2>Liste des produits</h2>
	<c:if test="${! empty produits}">
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOM</th>
						<th>QUANTITE</th>
						<th>PRIX</th>
						<th>MODIFIER</th>
						<th>SUPPRIMER</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${produits}">
						<tr>
							<td><c:out value="${p.id}"></c:out></td>
							<td><c:out value="${p.nom}"></c:out></td>
							<td><c:out value="${p.quantite}"></c:out></td>
							<td><c:out value="${p.prix}"></c:out></td>
							<td><a href="ModifierProduit?id=<c:out value="${p.id}"/>">Modifier</a></td>
							<td><a href="SupprimerProduit?id=<c:out value="${p.id}"/>">Supprimer</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<c:if test="${empty produits}">
	<p>Aucun produit</p>
	</c:if>
</body>
</html>