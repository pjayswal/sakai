<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h1>Cars currently in the shop</h1>
	<table>
	<c:forEach var="section" items="${sectionList}">
	<tr>
		<td>${section.id}</td>
		<td>${section.faculty.name}</td>
		<td>${section.startDate}</td>
		<td>${section.endDate}</td>
		<td>${section.course.title}</td>
		
<%-- 		<td><a href="books/${book.id}">edit</a></td> --%>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addBook.html"> Add a Book</a>
</body>
</html>