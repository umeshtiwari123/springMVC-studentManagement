<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to SignUp Page</title>
</head>
<body>
	<form:form action="signUpUser" modelAttribute="signupuser">

		<form:label path="name">Name:</form:label>
		<form:input path="name" />
		<br>
		<br>

		<form:label path="phone">Phone:</form:label>
		<form:input path="phone" />
		<br>
		<br>

		<form:label path="email">Email:</form:label>
		<form:input path="email" />
		<br>
		<br>

		<form:label path="pass">Password:</form:label>
		<form:input path="pass" />
		<br>
		<br>

		<input type="submit" value="SignUp">

	</form:form>
</body>
</html>