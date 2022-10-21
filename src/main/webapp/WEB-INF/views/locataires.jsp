<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client</title>
<%@ include file="bootstrap.jsp" %>
</head>
<body class="center">
	<%@ include file="menu.jsp" %>
	 <h2> <c:out value="${ message }"/> </h2>
    <div class="card text-center ambiny2">
		 <form method="post" action="listerLocataireRechercher" class="form-inline card-body">	 				
			  	<div class="form-group mx-sm-3 mb-2" id="designation">
				   <input type="text" class="form-control" name="valeur" placeholder="Recherche" >
				 </div>
			  	<button type="submit"  class="btn btn-primary mb-2">Rechercher</button>
			  		  	
				<form method="post" action="listerLocataire" class="form-inline mb-2">
				      <div id="designation">
				          <input type="submit" class="btn btn-success mx-sm-3 mb-2" value="Actualiser"/>
				      </div>						 
				</form>	
		 </form>  	
		</div>
	<br>
	
	
	<div class="card text-center ambiny">
			  <div class="card-header">
					Nouveau Client
			  </div>
			  <div class="card-body ">
			    <form  method="post" action="ajouterLocataire">
						  <div class="form-row">
						    <div class="form-group col-md-3">
						      <label>Nom</label>
						      <input type="text" class="form-control" name="nom" placeholder="Nom du client" required>
						    </div>
						    <div class="form-group col-md-3">
						      <label>Adresse</label>
						      <input type="text" class="form-control" name="adress" placeholder="Adresse du client" required>
						    </div>
						 
						    <div class="form-group col-md-3">
						      <input type="submit" class="btn btn-success mb-2 tantana" value="Ajouter"/>
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
      <th style="width:50px">Identifiant</th>
      <th style="width:100px">Nom</th>
      <th style="width:100px">Adresse</th>
      <th style="width:50px">Edition</th>
      <th style="width:50px">Suppréssion</th>
    </tr>
  </thead>
  <c:forEach var="locataire" items="${ allLocataires }" >
  <tbody>
    <tr class="<c:out value="${ locataire.idLocataire % 2 == 0 ? active-row : non-active }"/>">
     	<td>Cli_${ locataire.idLocataire }</td>
					<td>${ locataire.nom }</td>
					<td>${ locataire.adress }</td>
				
					<td><a class="btn btn-outline-info" href="editerLocataire?idLocataire=<c:out value="${ locataire.idLocataire }" />">Editer</a></td>
					<td><a class="btn btn-outline-danger" href="supprLocataire?idLocataire=<c:out value="${ locataire.idLocataire }" />">Supprimer</a></td>
    </tr>
  </tbody>
  </c:forEach>
</table>
</body>


</html>