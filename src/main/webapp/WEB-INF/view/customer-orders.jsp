<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All My Orders</title>
</head>
<body>
	<div class="container">
		<h1>
			<a href="${pageContext.request.contextPath}/" class="home-title-link">My
				Furniture Store</a>
		</h1>
		<hr />
		<h3>All Orders of ${loggedInUser}</h3>
		<ul>
			<c:forEach var="order" items="${orders}">
				<c:forEach var="product" items="${order.products}">
					<li>${product.name}</li>
				</c:forEach>
			</c:forEach>
		</ul>
	</div>
</body>
</html>