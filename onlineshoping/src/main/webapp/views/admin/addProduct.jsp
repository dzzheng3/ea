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

<form:form modelAttribute="product" action="saveProduct">	
    <table border="1">
      <tr>
        <td><form:label path="pName">pName:</form:label></td>
        <td><form:input path="pName" /></td>
      </tr>
      <tr>
        <td><form:label path="unitPrice">unitPrice:</form:label></td>
        <td><form:input path="unitPrice" /></td>
      </tr>
      <tr>
        <td><form:label path="description">description:</form:label></td>
        <td><form:textarea path="description" /></td>
      </tr>
      <tr>
        <td><form:label path="discount">discount:</form:label></td>
        <td><form:input path="discount" /></td>
      </tr>
      <tr>
        <td><form:label path="conditioned">conditioned:</form:label></td>
        <td><form:input path="conditioned" /></td>
      </tr>
      <tr>
        <td><form:label path="category.cName">category.cName":</form:label></td>
        <td><form:input path="category.cName"" /></td>
      </tr>
      <tr>
        <td><form:label path="category.description">category.description":</form:label></td>
        <td><form:input path="category.description"" /></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="saveProduct" /></td>
      </tr>
    </table>
    </form:form>
</body>
</html>