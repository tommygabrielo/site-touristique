<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Locataire</title>
<%@ include file="bootstrap.jsp" %>
</head>

<body>
<%@ include file="menu.jsp" %>
	   


		<div class="card text-center ambiny">
					  <div class="card-header">
							Modification Client
					  </div>
					  <div class="card-body ">
					    <form  method="post" action="modifLocataire">
					    <input type="hidden" name="idLocataire" value="<c:out value="${ idLocataire }" />"/>
								  <div class="form-row">
								    <div class="form-group col-md-3">
								      <label>Nom</label>
								      <input type="text" class="form-control" name="nom"  value="<c:out value="${ nom }"/>" required>
								    </div>
								    <div class="form-group col-md-3">
								      <label>Lieu</label>
								      <input type="text" class="form-control"  name="adress" value="<c:out value="${ adress }" />" required>
								    </div>								   
								    <div class="form-group col-md-3">
								      <input type="submit"  class="btn btn-success mb-2 tantana" value="Modifier"/>
								   	</div>
								   </div>
								    
								  </div>
							</form>
					
					  </div>
				</div>
</body>

</html>