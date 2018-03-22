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
<title>Furniture Store | All products</title>
</head>
<body>
	<div class="container">
		<h1>
			<a href="${pageContext.request.contextPath}/" class="home-title-link">My
				Furniture Store</a>
		</h1>
		<hr />
		<%
			if ((session.getAttribute("loggedInUser") == null) && (session.getAttribute("admin") == null)) {
		%>

		<a href="/showFormForLogin" class="btn btn-success inline-btn">Login</a>
		<a href="/showFormForSignUp" class="btn btn-info inline-btn">Sign
			Up</a><br> <br>
		<%
			}
		%>
		<%
			if ((session.getAttribute("loggedInUser") != null) || (session.getAttribute("admin") != null)) {
		%>
		<b>Hi, ${loggedInUser} ${admin.username}</b> <br> <a
			href="/logOutTheUser" class="btn btn-danger">Logout</a>
		<%
			if (session.getAttribute("customerId") != null) {
					long customerId = (long) session.getAttribute("customerId");
				
		%>
		<a href="/secure/orders/list?customerId=${customerId}"
			class="btn btn-info">My Orders</a><br> <br>
		<%
			}
		}
		%>
		<% 
		if(session.getAttribute("admin") != null) { %>
		<a href="/secure/admin/chooseACustomer"
			class="btn btn-info">Customer Orders</a><br><br>
		<% } %>
		<h3>All our products</h3>
		<div class="row">


			<c:forEach var="product" items="${products}">
				<c:url var="singlePageLink" value="/product/showProductDetail">
					<c:param name="productId" value="${product.id}" />
				</c:url>
				<div class="col-md-4">
					<p>
						<a href="${singlePageLink}" class="product-name">${product.name}</a>
					</p>
					<img
						src="${pageContext.request.contextPath}/resources/images/${product.image}"
						class="product-image" />
					<p class="price">
						$${product.price} | <a href="${singlePageLink}"
							class="details-link">View Detail</a>
					</p>

				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>