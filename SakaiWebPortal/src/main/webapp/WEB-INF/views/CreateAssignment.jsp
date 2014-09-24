<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<br>
	<br>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">Sections Assigned to Your</div>
		<div class="panel-body">
			<form:form class="form-horizontal" role="form" commandName="assignment" action="../uploadAssignment/${sectionId}"
				method="post" enctype="multipart/form-data">
				<div class="form-group">
					<form:label for="title" class="col-sm-2 control-label" path="title">Title</form:label>
					<div class="col-sm-10">
						<form:input type="text" name="title" id="title" path="title" placeholder="Title" />
					</div>
				<div class="col-sm-3">
					<form:errors path="title" cssClass="error" />
				</div>
				</div>
				<div class="form-group">
					<form:label for="details" class="col-sm-2 control-label" path="details">Details</form:label>
					<div class="col-sm-10">
						<form:input type="text" path="details" id="details" placeholder="Details" name="details" />
					</div>
					<div class="col-sm-3">
					<form:errors path="details" cssClass="error" />
				   </div>
				</div>


				<div class="form-group">
					<form:label for="openDate" class="col-sm-2 control-label" path="openDate">Open
						Date(dd-MM-yyyy):</form:label>
					<div class="col-sm-10">
						<form:input type="text" path="openDate" id="openDate" placeholder="Open Date" name="openDate" />
					</div>
				 <div class="col-sm-3">
					<form:errors path="openDate" cssClass="error" />
				</div>
				</div>


				<div class="form-group">
					<form:label for="dueDate" class="col-sm-2 control-label" path="dueDate">Due
						Date(dd-MM-yyyy):</form:label>
					<div class="col-sm-10">
						<form:input type="text" class="datepicker" id="dueDate" placeholder="Due Date" path="dueDate" name="dueDate" />
					</div>
				</div>
				


				<div class="form-group">
					<form:label for="gradePoint" class="col-sm-2 control-label" path="gradePoint">Grade
						Point:</form:label>
					<div class="col-sm-10">
						<form:input type="text" class="datepicker" id="gradePoint" placeholder="Grade Point" path="gradePoint" name="gradePoint" />
					</div>
				<div class="col-sm-3">
					<form:errors path="gradePoint" cssClass="error" />
				</div>
					
				</div>

				<div class="form-group">
					<form:label for="webFile" class="col-sm-2 control-label"  path="webFile">Upload
						assignment:
					</form:label>
					<div class="col-sm-10">
						<form:input type="file" name="webFile" id="webFile" placeholder="Upload Assignment" path="webFile" />
					</div>
				<div class="col-sm-3">
					<form:errors path="webFile" cssClass="error" />
				</div>
				</div>
				<div class="form-group">
					
						<button type="submit" class="btn btn-primary">Submit</button>
				</div>

			</form:form>

		</div>
	</div>
<!-- 	<div align="center"> -->
<%-- 		<a href="../uploadAssignment/${sectionId }"> --%>
<!-- 			<button type="button" class="btn btn-primary">Student -->
<!-- 				Administration</button> -->
<!-- 		</a> -->
<!-- 	</div> -->
</body>
</html>