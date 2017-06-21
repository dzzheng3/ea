<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty requestScope.products }">
	No products!
</c:if>
	<c:if test="${!empty requestScope.products }">
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Product Name</th>
				<th>Unit Price</th>
				<th>Description</th>
				<th>Units In Stock</th>
				<th>Discount</th>
				<th>Conditioned</th>
				<th>category.cName</th>
				<th>category.description</th>
			</tr>
			<c:forEach items="${requestScope.products }" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.pName}</td>
					<td>${product.unitPrice}</td>
					<td>${product.description}</td>
					<td>${product.unitsInStock}</td>
					<td>${product.discount}</td>
					<td>${product.conditioned}</td>
					<td>${product.category.cName}</td>
					<td>${product.category.description}</td>

					<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td><a href="/deleteProduct/${product.id }">Delete</a></td>
					<td><a href="/updateProduct/${product.id }">Update</a></td>
					</sec:authorize>
					
					
					<sec:authorize access="hasRole('ROLE_USER')">
					<td><a href="/addShoppingCart/${product.id }">Add To Cart</a></td>
					</sec:authorize>
					
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="/admin">go home</a>
</body>
</html>