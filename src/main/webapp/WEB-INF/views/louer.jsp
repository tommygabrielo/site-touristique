<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Louer</title>
	<%@ include file="bootstrap.jsp" %>
	<%@ include file="menu.jsp" %>
</head>
<body>	
	<div class="card text-center ambiny2">
		<div class="row">
			<div class="col-sm-9">
				<form method="post" action="listerLouerRechercher" class="form-inline card-body ">	 				
					<div class="form-group mx-sm-3 mb-2" id="designation">
						 <input type="text" class="form-control" name="valeur" placeholder="Recherche" >
					</div>
					
						<button type="submit"  class="btn btn-primary mb-2">Rechercher</button>  		
										
				 </form>  
			</div>
			
			<div class="col-sm-3" style="margin-top:10%">
				 <form method="post" action="listerLouer" class="form-inline mb-2 ">		
					<div id="designation">
						<input type="submit" class="btn btn-success mx-sm-3 mb-2" value="Actualiser"/>
					</div>						 
				</form>		
			</div>
		 
		
		</div>
		
	</div>
		 <h2 style="text-align:center"> <c:out value="${ message }"/> </h2>
	
	<br>
    
  	<div class="card text-center ambiny2">
		<div class="card-header">
			Recherche entre deux dates
		</div>
		<div class="card-body ">
			<form  method="post" action="listerLouerRechercherEntreDeuxDates">
				<div class="form-row">
					<div class="form-group col-md-3">						    
						<input type="date" class="form-control" name="date1"  required>
					</div>
					
					<div class="form-group col-md-3">
						<input type="date" class="form-control" name="date2" required>
					</div>
			
					<div class="form-group col-md-3">
						 <input type="submit" class="btn btn-primary mb-2" value="Rechercher"/>
					</div>
				</div>						    						 
			</form>	
		</div>
	</div>
	
	<br>
	
	<div class="card text-center ambiny">
		<div class="card-header">
			Nouvelle Visite
		</div>
		<div class="card-body ">
			<form  method="post" action="ajouterLouer">
				<div class="form-row">
					<div class="form-group col-md-3">
						<label>Nom Site</label>
							<select class="tantana" name="id_locataire" required>
						       <c:forEach var="m" items="${ listS }" >
						          <option value="${m.id_locataire }"> ${ m.nom_locataire } </option>
								</c:forEach>
						    </select>
					</div>
						    
					<div class="form-group col-md-3">
						<label>Nom visiteur</label>
							  <select class="tantana" name="id_visiteur" required>
						         <c:forEach var="m" items="${ listV }" >
						            <option value="${m.id_voiture }"> ${ m.num_voiture } </option>
								</c:forEach>
						      </select>
					</div>
					
			    	<div class="form-group col-md-2">
				      	<label>Nombre de jour</label>
				      	<input type="text" class="form-control" name="nbJour" placeholder="Nombre de jour " required>
				   	</div>
				   	
				   	 <div class="form-group col-md-2">
				      <label>date de location</label>
				      <input type="date" class="form-control" name="date" placeholder="Loyer de la site " required>
				   	</div>
				   	
				    <div class="form-group col-md-2">
				      <input type="submit" class="btn btn-success mb-2 tantana" value="Ajouter"/>
				   	</div>
				</div>				    				
			</form>	
	  </div>
	</div>		

<br>


	<table class="table table-striped  border border-dark" style="width:800px; margin-left:auto;margin-right:auto">
  		<thead>
		    <tr>
		      <th style="width:50px">Id</th>
		      <th style="width:100px">Client</th>
		      <th style="width:100px">Tarif</th>
		      <th style="width:100px">Nb jour</th>
		      <th style="width:50px">Montant</th>
		      <th style="width:150px">Date Location</th>
		      <th style="width:50px">Edition</th>
		      <th style="width:50px">Suppréssion</th>
		    </tr>
	  </thead>
  		<c:forEach var="louer" items="${ allLouers }" >
  	
  	<tbody>
    <tr>
     	<td>${ louer.idLouer }</td>
		<td>${ louer.nom_locataire }(Cli${ louer.id_locataire })</td>
		<td>${ louer.loyer }</td>
		<td> ${ louer.nbJour }j </td>
		<td> ${ louer.montant }  </td>
		<td> ${ louer.date } </td>
		<td><a class="btn btn-outline-info" href="editerLouer?idLouer=<c:out value="${ louer.idLouer }" />">Editer</a></td>
		<td><a class="btn btn-outline-danger" href="supprLouer?idLouer=<c:out value="${ louer.idLouer }" />">Supprimer</a></td>				
    </tr>
  </tbody>
  </c:forEach>
</table>
    
	
</body>
</html>