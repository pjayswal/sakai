<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<br>
<br>
<br>
<br>

	<form action="../courses/${course.id}" method="post">
	<table>
		<tr>
			<td>Title:</td>
			<td><input type="text" name="title" value="${course.title}" /> </td>
		</tr>
		<tr>
			<td>Description:</td>
			<td><input type="text" name="description" value="${course.description}" /> </td>
		</tr>
		<tr>
			<td>Subject Code:</td>
			<td><input type="text" name="subjectCode" value="${course.subjectCode}" /> </td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?id=${course.id}" method="post">
		<button type="submit">Delete</button>
	</form>
	
	<div class="panel panel-primary">
		<div class="panel-heading">Sections in the Selected Course</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Section ID</td>
						<td>Section Title</td>
						<td>Faculty</td>
						<td>Number of student enrolled</td>
					</tr>
				</thead>

				<c:forEach var="section" items="${sections}">
					<tbody>
						<tr>
							<td>${section.id}</td>
							<td>${section.title}</td>
							<td>${section.faculty.name}</td>
							<td>${fn:length(section.students)}</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>

		</div>
	</div>
	<a href="../sections/add?id=${course.id}">
			<button type="button" class="btn btn-success">Add Section</button>
	</a>
	
</body>
</html>