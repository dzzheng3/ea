<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="customer" action="addUser" method="post">	
<tr>
			<td>${customer.address.street} </td>			
			<td>${customer.address.city} </td>			
			<td>${customer.address.state} </td>			
			<td>${customer.address.zip} </td>			
			<td>${customer.address.country} </td>			
			<td>${customer.user.username} </td>			
			<td>${customer.user.password} </td>			
			<td>${customer.user.hasRole} </td>			
			<td>${customer.user.enabled} </td>			
			<td><a href="/deleteUser/${customer.id }">delete</a></td>			
			<td><a href="/updateUser/${customer.id }">update</a></td>			
		</tr>
    <table >
      <tr>
        <td><form:label path="fName">fName:</form:label></td>
        <td><form:input path="fName" /></td>
        <td><form:errors path="fName" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="lName">lName:</form:label></td>
        <td><form:input path="lName" /></td>
        <td><form:errors path="lName" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="phone">phone:</form:label></td>
        <td><form:input path="phone" /></td>
        <td><form:errors path="phone" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="email">email:</form:label></td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="dob">dob:</form:label></td>
        <td><form:input path="dob" /></td>
        <td><form:errors path="dob" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="identificationNumber">identificationNumber:</form:label></td>
        <td><form:input path="identificationNumber" /></td>
        <td><form:errors path="identificationNumber" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="address.street">identificationNumber:</form:label></td>
        <td><form:input path="address.street" /></td>
        <td><form:errors path="address.street" cssClass="error"/></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="addCategory" /></td>
      </tr>
    </table>
    </form:form>
</body>
</html>