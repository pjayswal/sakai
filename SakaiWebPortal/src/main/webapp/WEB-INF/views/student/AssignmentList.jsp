<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<br>
	<br>
	<br>


	<div class="panel panel-primary">
		<div class="panel-heading">Assignment List</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<td>ID</td>
						<td>Title</td>
						<td>Details</td>
						<td>Open Date</td>
						<td>Due Date</td>
						<td>Grade Point</td>
						<td>View Assignment</td>
						<td>Remark</td>

					</tr>
				</thead>

				<c:forEach var="assignment" items="${assignmentList }">
					<tbody>
						<tr>
							<td>${assignment.id }</td>
							<td>${assignment.title }</td>
							<td>${assignment.details }</td>
							<td>${assignment.openDate }</td>
							<td>${assignment.dueDate }</td>
							<td>${assignment.gradePoint }</td>
							<td><a href="<c:url value="/student/assignmentDownload/${assignment.id}"/>">Assignment</a></td>
							<td><a href="<c:url value="/student/solutionUpload/${assignment.id}"/>">Upload Solution</a></td>
							



						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>