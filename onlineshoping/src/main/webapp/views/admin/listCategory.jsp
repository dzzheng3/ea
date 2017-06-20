<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty requestScope.categorys }">
	No products!
</c:if>
	<c:if test="${!empty requestScope.categorys }">
		<table border="1">
			<tr>
				<th>id</th>
				<th>cName</th>
				<th>description</th>
			</tr>
			<c:forEach items="${requestScope.categorys }" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.cName}</td>
					<td>${category.description}</td>
					<td><a href="/deleteCategory/${category.id }">delete</a></td>
					<td><a href="/updateCategory/${category.id }">update</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<%@ include file="header.jsp"%>
</body>
</html>