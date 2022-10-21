<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Changement de delai</title>
<%@ include file="bootstrap.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
	<div class="card text-center ambiny2">
		<div class="card-header">
			Changement de delai
		</div>
		
		<div class="card-body center ">
			<form  method="post" action="modifLouer">
				<input type="hidden" name="idLouer" value="<c:out value="${ idLouer }" />"/>
				<div class="form-row">
					<div class="form-group col-md-3">
						<label>Nombre de jour</label>
						<input type="text" class="form-control" name="nbJour"  value="<c:out value="${ nbJour }" />" required>
					</div>
								   
					<div class="form-group col-md-3">
						<input type="submit" name="BT" class="btn btn-success mb-2 tantana" value="Modifier"/>
					</div>
				</div>							    		
			</form>			
		</div>
	</div>
	   
</body>
</html>