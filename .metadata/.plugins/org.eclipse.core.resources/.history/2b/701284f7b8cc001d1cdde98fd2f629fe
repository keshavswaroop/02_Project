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
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h2>Flights</h2>

	<table style="border:1px solide black">
		<tr>
			<th>FlightId</th>
			<th>Airlines</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Date</th>
			<th>TicketPrice</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach var="flight" items="${flights}">
			<tr>
				<td>FN${flight.id }</td>
				<td>${flight.airline.name }</td>
				<td>${flight.sourcePlace.name }</td>
				<td>${flight.destinationPlace.name }</td>
				<td>${flight.departureTime }</td>
				<td>${flight.price }</td>
				<td><a href="FlightUpdate?flightid=${flight.id }">Update</a></td>
				<td><a href="FlightDelete?flightid=${flight.id }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		Insert New Flight : <a style="padding:5px 20px 5px 20px" href="FlightAdd">Insert</a>
	</p>
	<p>
		<a style = "color:black;border:1px solid black;background-color:white" href="home.jsp">Home</a>
	</p>
	<p><p> <a style = "color:red;background-color:white;border:1px solid red" href="adminLogin.html">Logout</a></p>
</body>
</html>