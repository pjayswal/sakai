<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Section List</title>
</head>
<body>
	<h1>Sections Assigned to Your</h1>
	<table>
	<c:forEach var="section" items="${sectionList}">
	<tr>
		<td>${section.id}</td>
		<td>${section.faculty.name}</td>
		<td>${section.startDate}</td>
		<td>${section.endDate}</td>
		<td>${section.course.title}</td>
		<td>${fn:length(section.students) }</td>
		<td>${section.studentLimit }</td>
		<td><a href="getStudentList/${section.id}">View Details</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>