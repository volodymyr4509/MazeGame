<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 27.12.2014
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>

<form id = "fightOptionID">
    <table >
        <tr>
            <td>block</td>
            <td>target</td>
            <td>attack</td>
        </tr>
        <tr>
            <td><input type = "radio" name = "block" value = 0></td>
            <td>Head</td>
            <td><input type = "radio" name = "attack" value = 0></td>
        </tr>
        <tr>
            <td><input type = "radio" name = "block" value = 1></td>
            <td>Chest</td>
            <td><input type = "radio" name = "attack" value = 1></td>
        </tr>
        <tr>
            <td><input type = "radio" name = "block" value = 2></td>
            <td>Stomach</td>
            <td><input type = "radio" name = "attack" value = 2></td>
        </tr>
    </table>
</form>
<script src="<c:url value="/resources/javascripts/fight.js" />"></script>
</body>
</html>
