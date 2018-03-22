<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<div class="container">
		<h1>
			<a href="${pageContext.request.contextPath}/" class="home-title-link">My
				Furniture Store</a>
		</h1>
		<hr />
		<h3>Please Login</h3>
		<form:form action="logInTheAdmin" method="POST"
			modelAttribute="adminLogin">
			<table>
				<tr>
					<td>Username:</td>
					<td><form:input type="text" name="username" path="username" /></td>
					<td><form:errors path="username" cssClass="error-message"></form:errors></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input type="password" name="password" path="password" /></td>
					<td><form:errors path="password" cssClass="error-message"></form:errors></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"
						class="btn btn-success common-margin submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>