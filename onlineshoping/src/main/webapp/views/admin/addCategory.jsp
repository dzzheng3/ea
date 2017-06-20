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

<form:form modelAttribute="category" action="addCategory" method="post">	
    <table >
      <tr>
        <td><form:label path="cName">cName:</form:label></td>
        <td><form:input path="cName" /></td>
        <td><form:errors path="cName" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="description">description:</form:label></td>
        <td><form:input path="description" /></td>
        <td><form:errors path="description" cssClass="error"/></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="addCategory" /></td>
      </tr>
    </table>
    </form:form>
</body>
</html>