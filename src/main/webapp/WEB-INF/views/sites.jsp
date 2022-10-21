<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Site</title>
<%@ include file="bootstrap.jsp" %>
</head>

<body class="center">
	<%@ include file="menu.jsp" %>
		<div class="card text-center ambiny2">
		 <form method="post" action="listerRechercher" class="form-inline card-body">	 				
			  	<div class="form-group mx-sm-3 mb-2" id="designation">
				   <input type="text" class="form-control" name="valeur" id="nom" placeholder="Recherche" >
				 </div>
			  	<button type="submit" name="BT"  class="btn btn-primary mb-2">Rechercher</button>
			  		  	
				<form method="post" action="listerSite" class="form-inline mb-2">
				      <div id="designation">
				          <input type="submit" name="BT" class="btn btn-success mx-sm-3 mb-2" value="Actualiser"/>
				      </div>						 
				</form>	
		 </form>  	
		</div>
	<br>
		  
      
			<div class="card text-center ambiny">
			  <div class="card-header">
					Nouvelle site
			  </div>
			  <div class="card-body ">
			    <form  method="post" action="ajouterSite">
						  <div class="form-row">
						    <div class="form-group col-md-3">
						      <label>Nom</label>
						      <input type="text" class="form-control" name="nom" id="nom" placeholder="Nom de la Site" required>
						    </div>
						    <div class="form-group col-md-3">
						      <label>Lieu</label>
						      <input type="text" class="form-control" id="lieu" name="lieu" placeholder="Lieu touristique" required>
						    </div>
						    <div class="form-group col-md-3">
						      <label>Tarif journalier</label>
						      <input type="text" class="form-control" id="loyer" name="loyer" placeholder="Loyer de la site " required>
						   	</div>
						    <div class="form-group col-md-3">
						      <input type="submit" name="BT" class="btn btn-success mb-2 tantana" value="Ajouter"/>
						   	</div>
						   </div>
						    
						  </div>
					</form>
			
			  </div>
			</div>
<br>

<table class="table table-striped border border-dark" style="width:600px; margin-left:auto;margin-right:auto">
  <thead>
    <tr>
      <th style="width:50px">#</th>
      <th style="width:100px">Nom</th>
      <th style="width:100px">Lieu</th>
      <th style="width:50px">Tarif</th>
      <th style="width:50px">Edition</th>
      <th style="width:50px">Suppréssion</th>
    </tr>
  </thead>
  <c:forEach var="site" items="${ allSite }" >
  <tbody>
    <tr>
     	<td>${ site.id }</td>
					<td>${ site.nom }</td>
					<td>${ site.lieu }</td>
					<td>${ site.loyer }</td>
					<td><a class="btn btn-outline-info" href="editerSite?id=<c:out value="${ site.id }" />">Editer</a></td>
					<td><a class="btn btn-outline-danger" href="supprSite?id=<c:out value="${ site.id }" />">Supprimer</a></td>
    </tr>
  </tbody>
  </c:forEach>
</table>
</body>
</html>