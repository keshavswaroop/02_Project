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
	<h2>Airlines</h2>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Country</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach var="airline" items="${airlines}">
			<tr>
				<td>${airline.id }</td>
				<td>${airline.name }</td>
				<td>${airline.country }
				<td><a href="AirlineUpdate?airlineid=${airline.id }">Update</a></td>
				<td><a href="AirlineDelete?airlineid=${airline.id }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		Insert New Airline : <a style="color:white;padding:5px 20px 5px 20px" href="insertAirline.html">Insert</a>
	</p>
	<p>
		<a style="background-color:white;color:black;border:1px solid black" href="home.jsp">Home</a>
	</p>
	<p> <a style="color:red;background-color:white;border:1px solid red" href="adminLogin.html">Logout</a></p>
</body>
</html>