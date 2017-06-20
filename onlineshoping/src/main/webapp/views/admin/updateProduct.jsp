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
<table>
<form:form modelAttribute="product" action="/updateProduct/${product.id }" method="post">	
      <tr>
        <td><form:label path="pName">pName:</form:label></td>
        <td><form:input path="pName" value="${product.pName }"/></td>
        <td><form:errors path="pName" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="unitPrice">unitPrice:</form:label></td>
        <td><form:input path="unitPrice" value="${product.unitPrice }"/></td>
        <td><form:errors path="unitPrice" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="unitsInStock">unitsInStock:</form:label></td>
        <td><form:input path="unitsInStock" value="${product.unitsInStock }" /></td>
        <td><form:errors path="unitsInStock" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="description">description:</form:label></td>
        <td><form:textarea path="description" value="${product.description }"/></td>
        <td><form:errors path="description" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="discount">discount:</form:label></td>
        <td><form:checkbox path="discount" value="${product.discount }"/></td>
        <td><form:errors path="discount" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="conditioned">conditioned:</form:label></td>
        <td><form:input path="conditioned" value="${product.conditioned }"/></td>
        <td><form:errors path="conditioned" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="category.cName">category.cName:</form:label></td>
        <td><form:input path="category.cName" value="${product.category.cName }"/></td>
        <td><form:errors path="category.cName" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="category.description">category.description:</form:label></td>
        <td><form:input path="category.description" value="${product.category.description }"/></td>
        <td><form:errors path="category.description" cssClass="error"/></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="updateProduct" /></td>
      </tr>
    </form:form>
    </table>
</body>
</html>