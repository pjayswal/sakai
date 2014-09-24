<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
<jsp:param value="a" name="a"/>
</jsp:include>
<title>Welcome to Administration</title>
</head>
<body>
	<h1>List of Faculties Registered</h1>
	<table>
		<c:forEach var="faculty" items="${faculties}">
			<tr>
				<td>${faculty.id}&nbsp; </td>
				<td>${faculty.name}&nbsp; </td>
				
				
				<td><a href="faculties/${faculty.id}">View Details</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="faculties/add">
			<button type="button" class="btn btn-success">Add Faculty</button>
		</a>
</body>