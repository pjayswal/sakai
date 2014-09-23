<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Assignments for selected Section</title>
</head>
<body>
	<table>
	<c:forEach var="assignment" items="${assignmentList })"> 

		<tr>
		<td>${assignment.id }</td>
		<td>${assignment.title }</td>
		<td>${assignment.details }</td>
		<td>${assignment.openDate }</td>
		<td>${assignment.dueDate }</td>
		<td>${assignment.gradePoint }</td>
		<td>${assignment.assignments }</td>
		
		</tr>
		</c:forEach>
	</table>
</body>
</html>