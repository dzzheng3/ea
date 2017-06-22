<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
<div>
		<h2>Current User :</h2>
		<sec:authentication property="name" />
	</div>
	<br /><h3>Products</h3>
	<br />
	<a href="/listProduct">List Products</a>
	<br />
	<a href="/cartList">My Shopping Cart</a>
	<br />
	<br />
	<a href="/login">Logout</a>
	<%-- <%@ include file="admin/header.jsp"%>  --%>
</body>
</html>