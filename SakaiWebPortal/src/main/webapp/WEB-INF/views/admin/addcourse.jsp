<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<div class="navbar navbar-inverse navbar-default" role="navigation">
		<div class="container">
			<a class="navbar-brand" href="<c:url value=" /index.jsp"/>">Home</a>
			<label class="navbar-brand"><strong>Adding Course</strong></label>
		</div>
	</div>
	<div class="container">
		<form:form class="form-horizontal" role="form" commandName="course"
			action="./add" method="post">

			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">Title:
					</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control"
						path="title" id="title" placeholder="title"
						autocomplete="off" />
				</div>
				<div class="col-sm-3">
					<form:errors path="title" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">Description:</label>
				<div class="col-sm-7">
					<form:input type="description" cssClass="form-control" id="description"
						path="description" placeholder="description" autocomplete="off" />
				</div>
				<div class="col-sm-3">
					<form:errors path="description" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Course Code</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="subjectCode"
						path="subjectCode" placeholder="course code" />
				</div>
				<div class="col-sm-3">
					<form:errors path="subjectCode" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Save</button>
				</div>
			</div>
		</form:form>
		<footer>
			<p>&copy; Sakai Portal 2014</p>
		</footer>
	</div>
</body>