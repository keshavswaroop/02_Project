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

	<c:if test="${empty flightDetails }">
		<h1>No flights Available</h1>
		<p>To check for flights <a href="SearchFlight">Click here</a></p>
	</c:if>
	<c:if test="${!empty flightDetails }">
		<h1>Available Flights</h1>
		
		<table style="border: 1px solide black">
			<tr>
				<th>FlightId</th>
				<th>Airlines</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Date</th>
				<th>Ticket Price</th>
				<th>Select Flight</th>
			</tr>
			<c:forEach var="flight" items="${flightDetails}">
				<tr>
					<td>F${flight.id }</td>
					<td>${flight.airline.name }</td>
					<td>${flight.sourcePlace.name }</td>
					<td>${flight.destinationPlace.name }</td>
					<td>${flight.departureTime }</td>
					<td>${flight.price }</td>

					<td><a href="UserLogin?flightid=${flight.id }">Select</a></td>

				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>