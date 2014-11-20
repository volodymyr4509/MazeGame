<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HTML5 maze game</title>

    <script src="MoveThroughTheMaze.js" type="text/javascript"></script>
</head>
<body>
<h2>HTML5 Maze Game</h2>

<p>
    Welcome!<br />
    This is a HTML5 Maze Game .
</p>
<canvas width="616" height="556" id="mazecanvas">Can't load the maze game, because your browser doesn't support HTML5.</canvas>
<noscript>JavaScript is not enabled. To play the game, you should enable it.</noscript>

</body>
</html>
