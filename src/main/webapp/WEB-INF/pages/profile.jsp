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
<div id="userName" align="center">
    ${pageContext.request.userPrincipal.name} <br>
</div>

    <img src="/resources/avapes.jpg" />

<hr>
<!-- Player info-->
<button type="button" onclick="loadProfileInfo()">show profileinfo</button>
<script>
    function loadProfileInfo(){
        $.ajax({
            type:"GET",
            url: "/profile",
            dataType: 'json',
            data: $("#userName"),
            contentType: 'application/json; charset=utf-8',
            async: true,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
            cache: false,    //This will force requested pages not to be cached by the browser
            processData:false, //To avoid making query String instead of JSON
            success: function (playerInfo) {
                console.log("Player: " + playerInfo);
            },
            error: function (e) {
                console.log('error during loading player: ' + e);
            }
        });
    }
</script>

</body>
</html>
