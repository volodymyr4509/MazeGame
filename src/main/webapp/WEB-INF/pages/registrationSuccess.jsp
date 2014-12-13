<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Registration Success</title>
</head>
<body>
<div align="center">
    ${pageContext.request.userPrincipal.name} <br>
    <a href="register">Registration</a>
    <a href="login">Log in</a>
    <a href="maze">Maze</a>
</div>
<div align="center">
  <table border="0">
    <tr>
      <td colspan="2" align="center"><h2>Registration Succeeded!</h2></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <h3>Thank you for registering! Your profile:</h3>
      </td>
    </tr>
    <tr>
      <td>E-mail:</td>
      <td>${playerForm.email}</td>
    </tr>
    <tr>
      <td>Nick name:</td>
      <td>${playerForm.nickName}</td>
    </tr>
  </table>

</div>
</body>
</html>