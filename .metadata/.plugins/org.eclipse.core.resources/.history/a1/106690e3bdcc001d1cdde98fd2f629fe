<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="java.awt.print.Book"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="form.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>FlyAway</h1>
<h3>Search your flights</h3>
	<form action="SearchFlight" method="post">

		<label>From :</label> <select name="sourcePlace" required>
			<c:forEach var="sourcePlace" items="${sourcePlaces}">
				<option>${sourcePlace.name }
			</c:forEach>
		</select> 
		<label>To :</label> <select name="destinationPlace" required>
			<c:forEach var="destinationPlace" items="${destinationPlaces}">
				<option>${destinationPlace.name }
			</c:forEach>
		</select> 
		
		<label>Departure Date :</label> <input type="date" name="date" required/>
		 <label>Number of seats :</label> <input type="number" name="seats" required/> 
		 <input type="submit" value="submit" />
		 <p><a href="index.html">Back</a></p>
	</form>
</body>
</html>