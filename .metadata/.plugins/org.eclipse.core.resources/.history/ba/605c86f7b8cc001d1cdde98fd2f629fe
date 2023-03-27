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
<title>Booking Details</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h2>Booking Details</h2>

	<table style="border:1px solide black">
		<tr>
			<th>Name</th>
			<th>Phone</th>
			<th>Flight Number</th>
			<th>Airline Name</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Date</th>
			<th>TicketPrice</th>
		</tr>
		<c:forEach var="user" items="${useList}">
			<tr>
				<td>${user.name }</td>
				<td>${user.phone }</td>
				<td>FN${user.flight.id }</td>
				<td>${user.flight.airline.name }
				<td>${user.flight.sourcePlace.name }</td>
				<td>${user.flight.destinationPlace.name }</td>
				<td>${user.flight.departureTime }</td>
				<td>${user.flight.price }</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a style = "color:black;border:1px solid black;background-color:white" href="home.jsp">Home</a>
	</p>
	<p><p> <a style = "color:red;background-color:white;border:1px solid red" href="adminLogin.html">Logout</a></p>
</body>
</html>