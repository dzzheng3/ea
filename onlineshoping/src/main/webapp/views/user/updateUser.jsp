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
	<form:form modelAttribute="user" action="/admin/updatePersonAndSave">
		<c:if test="${user.id != null }">
			<form:hidden path="id" />
		</c:if>
		<table border="1">
			<tr>
				<td><form:label path="firstName">FirstName:</form:label></td>
				<td><form:input path="firstName" value="${user.firstName }" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">LastName:</form:label></td>
				<td><form:input path="lastName" value="${user.lastName }" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td><form:input path="email" value="${user.email }" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">phone:</form:label></td>
				<td><form:input path="phone" value="${user.phone }" /></td>
			</tr>
			<tr>
				<td><form:label path="address.city">City:</form:label></td>
				<td><form:input path="address.city"
						value="${user.address.city }" /></td>
			</tr>
			<tr>
				<td><form:label path="address.state">State:</form:label></td>
				<td><form:input path="address.state"
						value="${user.address.state }" /></td>
			</tr>
			<tr>
				<td><form:label path="address.country">Country:</form:label></td>
				<td><form:input path="address.country"
						value="${user.address.country }" /></td>
			</tr>
			<tr>
				<td><form:label path="address.zipcode">Zipcode:</form:label></td>
				<td><form:input path="address.zipcode"
						value="${user.address.zipcode }" /></td>
			</tr>
			<tr>
				<td><form:label path="enable">enable</form:label></td>
				<td><form:checkbox path="enable" value="${user.enable }" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="updatePerson" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>