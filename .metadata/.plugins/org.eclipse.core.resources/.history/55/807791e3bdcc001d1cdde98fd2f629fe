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
	<form action="FlightAdd" method="post">


		<label>Airlines :</label> <select name="airlines" required>
			<c:forEach var="airline" items="${airlines}">
				<option>${airline.name }
			</c:forEach>
		</select> 
		<label>Source Place :</label> <select name="sourcePlace" required>
			<c:forEach var="sourcePlace" items="${sourcePlaces}">
				<option>${sourcePlace.name }
			</c:forEach>
		</select> 
		<label>Destination Place :</label> <select name="destinationPlace" required>
			<c:forEach var="destinationPlace" items="${destinationPlaces}">
				<option>${destinationPlace.name }
			</c:forEach>
		</select> 
		<label>Departure Date :</label> <input type="date" name="date" required/>
		 <label>Ticket Price :</label> <input type="number" name="price" required/> 
		 <input type="submit" value="submit" />
	</form>
</body>
</html>