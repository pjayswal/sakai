<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<title>Welcome to Administration</title>
</head>
<body>
	<h1 class="text-center login-title">Welcome to Sakai System</h1>
	<h1 class="text-center login-title">----------------
		Administration ------------------</h1>
	<form action="students" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="eamil" /></td>
			</tr>

		</table>
		<table>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><input type="text" name="street" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>Roll Number:</td>
				<td><input type="text" name="roll" /></td>
			</tr>
		</table>

		<table>
			<tr>
				<td>User name:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password" /></td>
			</tr>
		</table>
		<select name="cars">
			<option value="ROLE_STUDENT">Student</option>
			<option value="ROLE_TEACHER">Teacher</option>
			<option value="ROLE_ADMIN">Administrator</option>
		</select> <input type="submit" />

	</form>

</body>
</html>

<body>
	<div class="navbar navbar-inverse navbar-default" role="navigation">
		<div class="container">
			<a class="navbar-brand" href="<c:url value=" /index.jsp"/>">Home</a> 
			<label class="navbar-brand"><strong>Adding Student</strong></label>
		</div>
	</div>
	<div class="container">
		<form:form class="form-horizontal" role="form" commandName="student"
			action="students" method="post">
			
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">User
					Name:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control"
						path="user.username" id="username" placeholder="User Name"
						autocomplete="off" />
				</div>
				<div class="col-sm-3">
					<form:errors path="user.username" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Password:</label>
				<div class="col-sm-7">
					<form:input type="password" cssClass="form-control" id="password"
						path="user.password" placeholder="password" autocomplete="off" />
				</div>
				<div class="col-sm-3">
					<form:errors path="user.password" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Name:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="name"
						path="name" placeholder="Student Name" />
				</div>
				<div class="col-sm-3">
					<form:errors path="name" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">Email:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="description"
						path="description" placeholder="email" />
				</div>
				<div class="col-sm-3">
					<form:errors path="email" cssClass="error" />
				</div>
			</div>
	
			<div class="form-group">
				<label for="phone" class="col-sm-2 control-label">Phone
					Number:</label>
				<div class="col-sm-7">
					<form:input type="tel" cssClass="form-control" id="phone"
						path="phone" placeholder="phone" />
				</div>
				<div class="col-sm-3">
					<form:errors path="phoneNumber" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="streetNo" class="col-sm-2 control-label">Street
					Address:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="streetNo"
						path="address.streetNo" placeholder="Street Address" />
				</div>
				<div class="col-sm-3">
					<form:errors path="address.streetNo" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="city" class="col-sm-2 control-label">City:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="city"
						path="address.city" placeholder="City" />
				</div>
				<div class="col-sm-3">
					<form:errors path="address.city" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="state" class="col-sm-2 control-label">State:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="state"
						path="address.state" placeholder="State" />
				</div>
				<div class="col-sm-3">
					<form:errors path="address.state" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="zip" class="col-sm-2 control-label">ZIP Code:</label>
				<div class="col-sm-7">
					<form:input type="text" cssClass="form-control" id="zip"
						path="address.zip" placeholder="Zip Code" />
				</div>
				<div class="col-sm-3">
					<form:errors path="address.zip" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Save</button>
				</div>
			</div>
		</form:form>
		<footer>
			<p>&copy; Job Portal 2014</p>
		</footer>
	</div>
</body>