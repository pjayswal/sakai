<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<h1>Students in the Selected Section</h1>
	<table>
	<c:forEach var="student" items="${studentList}">
	<tr>
		<td>${student.id}</td>
		<td>${student.rollNum}</td>
		<td>${student.name}</td>
		<td>${student.advisor.name}</td>
		<td>${fn:length(student.sections)}</td>
		
<%-- 		<td><a href="books/${book.id}">edit</a></td> --%>
	</tr>
	</c:forEach>
	</table>
	
</body>
</body>
</html>