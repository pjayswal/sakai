<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<script>
function validateForm()
{
    if(document.frm.username.value=="")
    {
      alert("User Name should not be blank..");
      document.frm.username.focus();
      return false;
    }
    else if(document.frm.pwd.value=="")
    {
      alert("Password should not be blank");
      document.frm.pwd.focus();
      return false;
    }
}
</script>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>Welcome to Administration</title>
</head>

<body>
	<div class="navbar navbar-inverse navbar-default" role="navigation">
		<div class="container">
			<a class="navbar-brand" href="<c:url value=" /index.jsp"/>">Home</a>
			<label class="navbar-brand"><strong>Adding Section</strong></label>
		</div>
	</div>
	<div class="container">
		<form:form class="form-horizontal" role="form" commandName="section"
			action="addSection?id=${course.id}" method="post">
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">Course:</label>
				<div class="col-sm-7">
					<input type="text" name="name" value="${course.title}" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="title" class="col-sm-2 control-label">Title:</label>
				<div class="col-sm-7">
					<form:input type="title" cssClass="form-control" id="title"
						path="title" placeholder="Title" autocomplete="off" />
				</div>
				<div class="col-sm-3">
					<form:errors path="title" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="startDate" class="col-sm-2 control-label">Start
					Date</label>
				<div class="col-sm-7">
					<form:input type="date" cssClass="form-control" id="startDate"
						path="startDate"  placeidholder="start date" />
				</div>
				<div class="col-sm-3">
					<form:errors path="startDate" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="endDate" class="col-sm-2 control-label">End Date</label>
				<div class="col-sm-7">
					<form:input type="date" cssClass="form-control" id="endDate"
						path="endDate" placeidholder="end date" />
				</div>
				<div class="col-sm-3">
					<form:errors path="endDate" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="faculty" class="col-sm-2 control-label">Faculty:</label>
				<div class="col-sm-7">
					<form:select path="faculty"  items="${faculties}" />
				</div>
				<div class="col-sm-3">
					<form:errors path="faculty" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="students" class="col-sm-2 control-label">Students:</label>
				<div class="col-sm-7">
					<form:select path="students" items="${students}" multiple="true" />
				</div>
				<div class="col-sm-3">
					<form:errors path="students" cssClass="error" />
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