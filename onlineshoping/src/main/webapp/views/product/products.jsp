<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Products</title>
</head>
<body>

<c:forEach items="${products}" var="products">
<div style="border:2px solid blue; width:300px;float:left; margin:5px">
<p> Product Name: ${products.pName }</p>

<p> Units in Stock: ${products.unitsInStock }</p>
<p> Category: ${products.category.cName } </p>
<br/>
<a href="/product?id=${products.id}">Details </a>
</div>
</c:forEach>

</body>
</html>