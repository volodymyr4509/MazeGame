<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Maze game</title>

    <!-- Load maze js -->
    <script src="<c:url value="/resources/javascripts/jquery-2.1.3.js" />"></script>
    <script src="<c:url value="/resources/javascripts/MoveThroughTheMaze.js" />"></script>
</head>
<body>

<div align="center">
    <!-- begin logout feature -->
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
    <!-- end logout feature -->

    <a href="profile">Player Profile</a>
</div>
<script>
    function saveFight(){
        var myJson = {"monsterNickname":"bat"};
        $.ajax({
            type:"POST",
            url: "/beginfight",
            dataType: 'json',
            data: JSON.stringify(myJson),
            contentType: 'application/json; charset=utf-8',
            async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false,    //This will force requested pages not to be cached by the browser
            processData:false, //To avoid making query String instead of JSON
            success: function (response) {
                console.log("fight was saved: " + response);
            },
            error: function (e) {
                console.log('cannt save fight: ' + e);
            }
        });
    }

</script>
<button type = 'button' onclick='saveFight()'>begin Fight</button>
<script>
    function sendkick(){
        var kickparam = $("#fightOptionID").serialize();
        $.ajax({
            type:"POST",
            url: "/kick",
            dataType: 'json',
            data: JSON.stringify(kickparam),
            contentType: 'application/json; charset=utf-8',
            async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false,    //This will force requested pages not to be cached by the browser
            processData:false, //To avoid making query String instead of JSON
            success: function (response) {
                console.log("kick success: " + response);
            },
            error: function (e) {
                console.log('cannt save kick: ' + e);
            }
        });
    }

</script>
<button type = 'button' onclick='sendkick()'>send kick</button>
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
        <sec:authorize ifAnyGranted='ROLE_USER'>
            <%@ include file="profile.jsp"%>
        </sec:authorize>
    </td>
    <!-- fight parameters -->
    <td width="10%"><%@include file="fightForm.jsp"%></td>
    <!-- Monster -->
    <td width="25%"><%@include file="monster.jsp"%></td>
</tr>
    <tr>
        <td>here place for conversations</td>
        <td>Here place for fight log</td>
    </tr>
</table>
</body>

</html>
