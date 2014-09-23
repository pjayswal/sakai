<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<form action="createAssignment/${id }" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>Details:</td>
				<td><input type="text" name="details" /></td>
			</tr>
			<tr>
				<td>Open Date:</td>
				<td><input type="text" name="openDate" /></td>
			</tr>
			<tr>
				<td>Due Date:</td>
				<td><input type="text" class="datepicker" name="dueDate" /></td>
			</tr>
			<tr>
				<td>Grade Point:</td>
				<td><input type="text" class="datepicker" name="gradePoint" /></td>
			</tr>
			<tr>
				<td>Upload assignment:<input type="file" name="assignmentFile" /></td>
				<td><input type="text" name="assignments" /></td>
			</tr>
			
		</table>
	</form>
</body>
</html>