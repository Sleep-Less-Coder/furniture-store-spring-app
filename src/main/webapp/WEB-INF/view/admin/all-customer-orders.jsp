<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Furniture Store | All products</title>
</head>
<body>
	<div class="container">
		<h1>
			<a href="${pageContext.request.contextPath}/" class="home-title-link">My
				Furniture Store</a>
		</h1>
		<hr />
	<h3>Choose a customer</h3>
	<form:form method="GET" action="getOrderOfaCustomer" modelAttribute="selectCustomer">
		<form:select id="customerSelector" name="customerSelector" path="customerId" class="form-control customer-chooser">
			<c:forEach var="customer" items="${customers}">
				<form:option value="${customer.id}">${customer.firstName} ${customer.lastName}</form:option>
			</c:forEach>
		</form:select>
		<input type="submit" value="Go" id="submit-btn" class="btn btn-success"/>
	</form:form>
	</div>
</body>
</html>