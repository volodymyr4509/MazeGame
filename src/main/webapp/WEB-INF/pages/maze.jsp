<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<<<<<<< HEAD
<head>
    <title>Maze game</title>
</head>
<body>
<h2>Welcome to Maze Game</h2> <br>
<table border="1" style="width:100%">
    <tr>
        <td>
            <canvas width="60" height="30" id="clock">Can't load the maze game, because your browser doesn't support HTML5.</canvas>
            <br>
            <canvas width="616" height="556" id="mazecanvas">Just use chrome!</canvas>
        </td>

        <td>
            Hero avatar
        </td>
        <td>fight options</td>
        <td>monster avatar</td>
    </tr>
    <tr>
        <td>here place for conversations</td>
        <td>Here place for fight log</td>
    </tr>

</table>




<script src="<c:url value="/resources/MoveThroughTheMaze.js" />"></script>
</body>

</html>
