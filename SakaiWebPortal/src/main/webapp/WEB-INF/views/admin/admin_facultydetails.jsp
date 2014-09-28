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



<%-- </body>		</tr>
				<tr>
					<td>User name:</td>
					<td><input type="text" name="username"
						value="${faculty.user.username}" /></td>
				</tr>

			</table>
			<input type="submit" value="update" />
		</form>
		<form action="delete?bookId=${faculty.id}" method="post">
			<button type="submit">Delete</button>
		</form>
</body>
</html> --%>

<body>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
	<form:form class="form-horizontal" role="form" commandName="faculty"
			action="../students/${faculty.id}" method="post">

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name: </label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" path="name"
						id="name" autocomplete="on" value="${faculty.name}" />
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
						value="${faculty.user.username}" autocomplete="on" readOnly />
				</div>
				<div class="col-sm-3">
					<form:errors path="user.username" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">Update</button>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				<a href="delete?id=${faculty.id}">
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