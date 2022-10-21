<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification Site</title>
<%@ include file="bootstrap.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
	   


		<div class="card text-center ambiny">
					  <div class="card-header">
							Modification site
					  </div>
					  <div class="card-body ">
					    <form  method="post" action="modifSite">
					    <input type="hidden" name="id" value="<c:out value="${ id }" />"/>
								  <div class="form-row">
								    <div class="form-group col-md-3">
								      <label>Nom</label>
								      <input type="text" class="form-control" name="nom" id="nom"  value="<c:out value="${ nom }"/>" required>
								    </div>
								    <div class="form-group col-md-3">
								      <label>Lieu</label>
								      <input type="text" class="form-control" id="lieu" name="lieu" value="<c:out value="${ lieu }" />" required>
								    </div>
								    <div class="form-group col-md-3">
								      <label>Tarif journalier</label>
								      <input type="text" class="form-control" id="loyer" name="loyer" value="<c:out value="${ loyer }" />" required>
								   	</div>
								    <div class="form-group col-md-3">
								      <input type="submit" name="BT" class="btn btn-success mb-2 tantana" value="Modifier"/>
								   	</div>
								   </div>
								    
								  </div>
							</form>
					
					  </div>
				</div>
</body>
</html>