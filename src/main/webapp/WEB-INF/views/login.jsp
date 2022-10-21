<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<%@ include file="bootstrap.jsp" %>
	<style type="text/css"><link rel="stylesheet" href="style/assets/dist/css/adminlte.min.css"></style> 
	<style type="text/css"> <link rel="stylesheet" href="style/Content/bootstrap.css"/></style>
   	<style type="text/css"><link rel="stylesheet" href="style/Content/style.css"/></style> 
	<style type="text/css"><link rel="stylesheet" href="style/assets/dist/fontawesome-free/css/all.min.css"></style>
	<style type="text/css">  <link rel="stylesheet" href="assets/dist/css/login.css"></style>
	 <style type="text/css"> <link rel="stylesheet" href="assets/plugins/toastr/toastr.min.css"></style>  
  

   
	</head>

<body class="bodyLogin">
	<div class="afovoany">
		<p class="bienvenu"> Bienvenu à notre page </p>
		<br>
	    <form method="post" action="listerSite">
	        <div class="from-group" align="center">
	            <input type="submit" name="OK" class="btn btn-primary" value="Se connecter"/>
	        </div>
	        <br>
	        <br>
    	</form> 	
	</div>	
</body>
</html>