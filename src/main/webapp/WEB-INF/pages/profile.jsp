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
    <script src="<c:url value="/resources/javascripts/profile.js" />"></script>
</head>
<body>
<div id="currentPlayerNickName" align="center">${pageContext.request.userPrincipal.name}</div>
<hr>

    <img src="/resources/warrior.png" />

<hr>
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





<button type="button" onclick="loadProfileInfo()">show profileinfo</button>

</body>
</html>
