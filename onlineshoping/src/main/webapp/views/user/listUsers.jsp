<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Customers</title>
</head>
<body>
<c:if test="${empty requestScope.users }">
	No Users!
</c:if>
<c:if test="${!empty requestScope.users }">
	<table border="1"><tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Phone</th>
			<th>City</th>
			<th>State</th>
			<th>Country</th>
			<th>Zipcode</th>
			
		</tr>
		<c:forEach items="${requestScope.users }" var="customer">
		<tr>
			<td>${customer.id} </td>			
			<td>${customer.fName} </td>			
			<td>${customer.lName} </td>			
			<td>${customer.email} </td>			
			<td>${customer.phone} </td>			
			<td>${customer.address.street}, ${customer.address.city} </td>						
			<td>${customer.address.state} </td>			
			<td>${customer.address.country} </td>			
			<td>${customer.address.zipcode} </td>			
					
			<td><a href="/admin/manageUser/${customer.id }">Update</a></td>			
		</tr>
		</c:forEach>
	</table>
</c:if>
<a href="/admin">Go home</a>
</body>
</html>