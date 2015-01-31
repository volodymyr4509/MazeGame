<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 06.12.2014
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<div align="center">
    ${pageContext.request.userPrincipal.name} <br>
</div>

    <img src="/resources/avapes.jpg" />

<hr>
<!-- Player info-->
<div id="playerinfo">

</div>

</body>
</html>
