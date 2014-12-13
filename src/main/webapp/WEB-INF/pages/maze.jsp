<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Maze game</title>
</head>
<body>
<!-- logout feature -->
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h4>
        Welcome to maze : ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()"> Logout</a>
    </h4>
</c:if>
<br>

<!-- game table -->
<table border="1" style="width:100%">
    <tr>
        <!-- maze -->
        <td width="40%">
            <canvas width="60" height="30" id="clock">Can't load the maze game, because your browser doesn't support HTML5.</canvas>
            <br>
            <canvas width="616" height="556" id="mazecanvas">Just use chrome!</canvas>
        </td>
        <!-- Hero -->
        <td width="25%">
            Hero avatar
        </td>
        <!-- fight parameters -->
        <td width="10%">fight options</td>
        <!-- Monster -->
        <td width="25%">monster avatar</td>
    </tr>
    <tr>
        <td>here place for conversations</td>
        <td>Here place for fight log</td>
    </tr>
</table>
<!-- Load maze js -->
<script src="<c:url value="/resources/MoveThroughTheMaze.js" />"></script>
</body>

</html>
