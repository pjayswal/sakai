<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Section List</title>
</head>
<body>
	<br></br>
	<br></br>
	<div class="panel panel-primary">
		<div class="panel-heading">Sections Assigned to Your</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Section ID</td>
						<td>Faculty Name</td>
						<td>Start Date</td>
						<td>End Date</td>
						<td>Course Title</td>
						<td>Number of Student</td>
						<td>Student limit</td>
						<td>Click for Details</td>
					</tr>
				</thead>
				<c:forEach var="section" items="${sectionList}">
					<tbody>
						<tr>

							<td>${section.id}</td>
							<td>${section.faculty.name}</td>
							<td>${section.startDate}</td>
							<td>${section.endDate}</td>
							<td>${section.course.title}</td>
							<td>${fn:length(section.students) }</td>
							<td>${section.studentLimit }</td>
							<td><a href="assignmentList/${section.id}">View Details</a></td>
						</tr>
					</tbody>

				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>