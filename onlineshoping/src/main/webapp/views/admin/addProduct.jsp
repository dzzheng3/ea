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

	<form:form modelAttribute="product" action="addProduct" method="post">
		<table>
			<tr>
				<td>Category:</td>
				<td><form:select  path="category"
						items="${categories}" itemValue="Id" itemLabel="cName" /></td>
				<td><form:errors path="category" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td><form:label path="pName">pName:</form:label></td>
				<td><form:input path="pName" /></td>
				<td><form:errors path="pName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="unitPrice">unitPrice:</form:label></td>
				<td><form:input path="unitPrice" /></td>
				<td><form:errors path="unitPrice" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="unitsInStock">unitsInStock:</form:label></td>
				<td><form:input path="unitsInStock" /></td>
				<td><form:errors path="unitsInStock" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="description">description:</form:label></td>
				<td><form:textarea path="description" /></td>
				<td><form:errors path="description" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="discount">discount:</form:label></td>
				<td><form:checkbox path="discount" /></td>
				<td><form:errors path="discount" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="conditioned">conditioned:</form:label></td>
				<td><form:input path="conditioned" /></td>
				<td><form:errors path="conditioned" cssClass="error" /></td>
			</tr>
			<!-- <tr>
				<td><form:label path="category.cName">category.cName:</form:label></td>
				<td><form:input path="category.cName" /></td>
				<td><form:errors path="category.cName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="category.description">category.description:</form:label></td>
				<td><form:input path="category.description" /></td>
				<td><form:errors path="category.description" cssClass="error" /></td>
			</tr> -->
			<tr>
				<td colspan="2"><input type="submit" value="addProduct" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>