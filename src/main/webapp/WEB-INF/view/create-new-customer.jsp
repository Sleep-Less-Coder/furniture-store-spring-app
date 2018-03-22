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
<title>New Customer Sign Up</title>
</head>
<body>
	<div class="container">
		<h1>
			<a href="${pageContext.request.contextPath}/" class="home-title-link">My
				Furniture Store</a>
		</h1>
		<hr />
		<h3>New Customer Sign Up</h3>
		<form:form method="POST" modelAttribute="customer"
			action="createCustomer">
			<table class="create-form-table">
				<form:hidden path="id" />
				<tr>
					<td>Firstname:</td>
					<td><form:input id="firstName" path="firstName" /></td>
					<td><form:errors path="firstName" cssClass="error-message"></form:errors></td>
				</tr>
				<tr>
					<td>Lastname:</td>
					<td><form:input id="lastName" path="lastName" /></td>
					<td><form:errors path="lastName" cssClass="error-message"></form:errors></td>
				</tr>
				<tr>
					<td>Email address:</td>
					<td><form:input id="email" path="email" /></td>
					<td><form:errors path="email" cssClass="error-message"></form:errors></td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><form:input id="username" path="customerLogin.username" /></td>
					<td><form:errors path="customerLogin.username" cssClass="error-message"></form:errors></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password id="password" path="customerLogin.password" /></td>
					<td><form:errors path="customerLogin.password" cssClass="error-message"></form:errors></td>
				</tr>
				<tr>
					<td><input type="submit" value="Sign Up"
						class="btn  btn-success common-margin"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>