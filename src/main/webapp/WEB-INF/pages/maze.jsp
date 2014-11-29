<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>HTML5 maze game</title>


    </head>
    <body>


        <h2>Welcome to Maze Game</h2>
        <br>
        <canvas width="60" height="30" id="clock">Can't load the maze game, because your browser doesn't support HTML5.</canvas>
        <br>
        <canvas width="616" height="556" id="mazecanvas">Just use chrome!</canvas>

        <script src="<c:url value="/resources/MoveThroughTheMaze.js" />"></script>
    </body>
</html>
