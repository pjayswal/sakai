<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<form action="../students/${student.id}" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${student.name}" /> </td>
		</tr>
		<tr>
			<td>User name:</td>
			<td><input type="text" name="username" value="${student.user.username}" /> </td>
		</tr>
		<tr>
			<td>Roll Number:</td>
			<td><input type="text" name="rollNum" value="${student.rollNum}" /> </td>
		</tr>
		<tr>
			<td>Advisor:</td>
			<td><input type="text" name="advisor" value="${student.advisor}" /> </td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?bookId=${book.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>