<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 12/2/2014
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home page</title>
</head>
<body>


    <div align="center">
        ${pageContext.request.userPrincipal.name} <br>
        <a href="register">Registration</a>
        <a href="login">Log in</a>
        <a href="maze">Maze</a>
    </div>
    <hr>
    <div align="center">
        MoleMaze. Version 0.1 beta. Refactored all js code.
    </div>

</body>
</html>
