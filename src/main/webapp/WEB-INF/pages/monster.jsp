<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 27.12.2014
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<img id="monsterAvatarID" src="/resources/kazan.svg" />

<hr>
<!-- Monster info-->
<c:if test="${not empty specificationsList}">

    <ul>
        <c:forEach var="listValue" items="${specificationsList}">
            <li>${listValue}</li>
        </c:forEach>
    </ul>

</c:if>
</body>
</html>
