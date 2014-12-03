<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<<<<<<< HEAD
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Registration</title>
</head>
<body>
<div align="center">
  <form:form action="register" method="post" commandName="playerForm">
    <table border="0">
      <tr>
        <td colspan="2" align="center"><h2>Spring MVC Form Demo - Registration</h2></td>
      </tr>
      <tr>
        <td>First name:</td>
        <td><form:input path="firstName" /></td>
      </tr>
      <tr>
        <td>Last name:</td>
        <td><form:input path="lastName" /></td>
      </tr>
      <tr>
        <td>Nick name:</td>
        <td><form:input path="nickName" /></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><form:password path="password" /></td>
      </tr>
      <tr>
        <td>E-mail:</td>
        <td><form:input path="email" /></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" value="Register" /></td>
      </tr>
    </table>
  </form:form>

</div>
</body>
</html>