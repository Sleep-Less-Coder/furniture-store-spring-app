<%@page import="com.hemant.furniture.store.entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
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
<title>Product Detail</title>
</head>
<body>
	<div class="container">
		<h1>
			<a href="${pageContext.request.contextPath}/" class="home-title-link">My
				Furniture Store</a>
		</h1>
		<hr />
		<div>
			<h3>${product.name}</h3>
			<p class="product-desc">${product.description}</p>
			<img
				src="${pageContext.request.contextPath}/resources/images/${product.image}"
				class="detail-page-image" />
			<ul>
				<li>Category: <b>${product.category}</b></li>
				<li>Price: <b>${product.price}</b></li>
			</ul>
		</div>

		<%
			if (session.getAttribute("loggedInUser") != null) {
		%>
		<%
			if (session.getAttribute("customerId") != null) {
					long customerId = (long) session.getAttribute("customerId");
				}
		%>
		<form:form action="/secure/orders/create" method="POST"
			modelAttribute="createNewOrder">
			<form:hidden path="customer.id" value="${customerId}" />
			<form:hidden path="product.id" value="${product.id}" />
			<!-- <input type="text" name="quantity" placeholder="Enter quantity.."
			required=required />
		<br />
		<br />
		<span>Total: <b>$0.00</b></span>
		<br /> -->
			<br />
			<input type="submit" value="Order" class="btn btn-info" />
		</form:form>
		<%
			} else if(session.getAttribute("admin") != null){
				
			} else {
		%>
		<div class="alert alert-info" role="alert" style="max-width: 500px">
			Please <a href="/showFormForLogin">login</a> to order this item.
		</div>
		<% } %>
	</div>
</body>
</html>