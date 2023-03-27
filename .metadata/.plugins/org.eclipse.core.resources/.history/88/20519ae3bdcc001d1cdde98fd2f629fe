<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="ticketConfirm.css" rel="stylesheet" type="text/css">
<link href="user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<h1>Thank You for Your Payment!</h1>
		<p>Your booking has been confirmed. Please check your email for your e-ticket.</p>
		<a href="SearchFlight">Back to home</a>
	</div>
	<div style="background-color: white;font-size:10px" class="user-details">
		<div  class="user-info">
			<h2>User Information</h2>
			<p>Name : ${user.name }</p>
			<p>Email : ${user.email }</p>
			<p>Phone : ${user.phone }</p>
			<p>Address : ${user.address }</p>
			<%Random rand = new Random(); 
				int n=rand.nextInt(9000000)+100000;
			%>
		</div>
		<div class="flight-info">
			<h2>Flight Information</h2>
			<p>Flight Number : FN${user.flight.id }
			<p>Airlines : ${user.flight.airline.name }
			<p>From : ${user.flight.sourcePlace.name }</p>
			<p>To   : ${user.flight.destinationPlace.name }</p>
			<p>Departure Date : ${user.flight.departureTime }</p>
			<p>Seats : ${seats }</p>
			<p>Ticket Price : ${total}</p>
			<p>Transaction Id : TNID<%= n %></p>
			<button style="color: black;
	background-color: white;
	padding: 10px;
	border:1px solid black;margin-top:10px" type="button" onclick="window.print()">Download Ticket Details</button>
		</div>
	</div>
	
	
	
	
	
	
</body>
</html>