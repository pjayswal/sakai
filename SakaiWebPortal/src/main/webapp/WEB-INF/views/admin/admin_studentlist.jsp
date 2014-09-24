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
	<h1>List of Students Registered</h1>
	<table>
		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.id}&nbsp; </td>
				<td>${student.name}&nbsp; </td>
				<td>${student.advisor.name}&nbsp;</td>
				<td>${student.rollNum}&nbsp;</td>
				
				
				<td><a href="students/${student.id}">View Details</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="students/add">
			<button type="button" class="btn btn-success">Add Student</button>
		</a>
</body>