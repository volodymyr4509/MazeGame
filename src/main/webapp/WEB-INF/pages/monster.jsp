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

<img id="monsterAvatarID" src="/resources/emptyspace.png" />

<hr>
<!-- Monster info-->
<c:if test="${not empty specificationsList}">

    <ul>
        <c:forEach var="listValue" items="${specificationsList}">
            <li>${listValue}</li>
        </c:forEach>
    </ul>

</c:if>

<!-- Player info-->
<table border="1" id="playerInfo">
    <tr>
        <td>
            <p>PlayerDetails:</p>
        </td>
        <td>
            <p>CurrentPlayerState:</p>
        </td>
    </tr>
    <tr>
        <td>
            <div id="playerhealth">Health: </div>
            <div id="playermuscle">Muscle: </div>
            <div id="playerwins">Wins: </div>
            <div id="playerloses">Loses: </div>
        </td>
        <td>
            <div id="currentplayerhealth">Current Health: </div>
            <div id="currentplayermuscle">Current Muscle: </div>
            <div id="infight">In Fight: </div>
        </td>
    </tr>
</table>
</body>
</html>
