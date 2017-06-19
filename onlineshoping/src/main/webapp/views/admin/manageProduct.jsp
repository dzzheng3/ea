<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div> Current User : <sec:authentication property="name"/></div>
Manage products:
	<br />
	<a href="/addProduct">Add Product</a>
	<br />
	<br />
	<a href="/listProduct">List Product</a>
	<br />
	<br /> 
	<br />
	<a href="/admin/createPerson">Manage Catagory</a>
	<br />
	<br /> 
	<br />
	<a href="/admin/listOrder">Manage Users</a>
	<br />
	<br />
	<a href="/logout">logout</a>
	Manage Coment:
	<br />
	<a href="/admin/listOrder">List orders</a>
	<br />
	<br />
	<a href="/login">logout</a>
</body>
</html>