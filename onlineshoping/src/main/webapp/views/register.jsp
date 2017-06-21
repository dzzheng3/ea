<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New User</title>
</head>
<body>
	<table>
		<form:form modelAttribute="customer" action="/register" method="post">
			<tr>
				<td><form:label path="fName">FirstName:</form:label></td>
				<td><form:input path="fName" /></td>
				<td><form:errors path="fName" /></td>
			</tr>
			<tr>
				<td><form:label path="lName">LastName:</form:label></td>
				<td><form:input path="lName" /></td>
				<td><form:errors path="lName" /></td>
			</tr>
			<tr>
				<td><form:label path="dob">Date of Birth:</form:label></td>
				<td><form:input path="dob" /></td>
				<td><form:errors path="dob" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td><form:label path=" identificationNumber">Identification No:</form:label></td>
				<td><form:input path=" identificationNumber" /></td>
				<td><form:errors path=" identificationNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone:</form:label></td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" /></td>
			</tr>
			<tr>
				<td><form:label path="address.street">Street:</form:label></td>
				<td><form:input path="address.street" /></td>
				<td><form:errors path="address.street" /></td>
			</tr>
			<tr>
				<td><form:label path="address.city">City:</form:label></td>
				<td><form:input path="address.city" /></td>
				<td><form:errors path="address.city" /></td>
			</tr>
			<tr>
				<td><form:label path="address.state">State:</form:label></td>
				<td><form:input path="address.state" /></td>
				<td><form:errors path="address.state" /></td>
			</tr>

			<tr>
				<td><form:label path="address.zip">Zipcode:</form:label></td>
				<td><form:input path="address.zip" /></td>
				<td><form:errors path="address.zip" /></td>
			</tr>
			<tr>
				<td><form:label path="address.country">Country:</form:label></td>
				<td><form:input path="address.country" /></td>
				<td><form:errors path="address.country" /></td>
			</tr>

			<tr>
				<td><form:label path="user.username">Username:</form:label></td>
				<td><form:input path="user.username" /></td>
				<td><form:errors path="user.username" /></td>
			</tr>
			<tr>
				<td><form:label path="user.password" type="password">Password:</form:label></td>
				<td><form:input path="user.password" /></td>
				<td><form:errors path="user.password" /></td>
			</tr>


			<tr>
				<td><form:hidden path="user.enabled" value="false" /></td>
				<td colspan="2"><input type="submit" value="Register" /></td>
			</tr>

		</form:form>
	</table>

</body>
</html>