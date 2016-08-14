<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login Page</title>
</head>
<body>
<form:form name="loginForm" method="post" action="login.do" methodAttribute="login">


<h1>Login Page</h1>
<c:if test="${not empty error}">
     <p style="color:red;"> Invalid Credentials. Your username or password is incorrect.</p>
</c:if>
<table>
<tr>
<td>Username:<input type="text" name="username"/></td>
</tr>
<tr>
<td>Password:<input type="password" name="password"/></td>
</tr>
<tr>
<td><input type="submit" value="Login"/></td>
</tr>
</table>


</form:form>
</body>
</html>