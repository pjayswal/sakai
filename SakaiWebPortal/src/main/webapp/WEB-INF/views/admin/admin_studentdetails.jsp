<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>Welcome to Administration</title>
</head>

<body>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<form:form class="form-horizontal" role="form" commandName="student"
			action="../students/${student.id}" method="post">

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name: </label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" path="name"
						id="name" autocomplete="on" value="${student.name}" />
				</div>
				<div class="col-sm-3">
					<form:errors path="name" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">User
					name:</label>
				<div class="col-sm-7">
					<input type="text" id="username" name="user.username"
						value="${student.user.username}" autocomplete="on" readOnly />
				</div>
				<div class="col-sm-3">
					<form:errors path="user.username" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="rollno" class="col-sm-2 control-label">Roll
					Number:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="rollno"
						path="rollNum" value="${student.rollNum}" />
				</div>
				<div class="col-sm-3">
					<form:errors path="rollNum" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="advisor" class="col-sm-2 control-label">Advisor:</label>
				<div class="col-sm-7">
					<input type="text" cssClass="form-control" id="rollno"
						name="advisor" value="${student.advisor.name}" readonly="readonly" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Update</button>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				<a href="delete?id=${student.id}">
					<button type="button" class="btn btn-primary">Delete</button>
				</a>
				</div>
			</div>


		</form:form>

		

		<footer>
			<p>&copy; Sakai Portal 2014</p>
		</footer>
	</div>
</body>

</html>