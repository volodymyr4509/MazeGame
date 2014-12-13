<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 06.12.2014
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

    <div align="center">
        ${pageContext.request.userPrincipal.name} <br>
        <a href="register">Registration</a>
        <a href="maze">Maze</a>
    </div>
    <br>
    <div align="center" id="login-box">

        <h4>Login with Username and Password</h4>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>

        <form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>

            <table>
                <tr>
                    <td>User:</td>
                    <td><input type='text' name='username' value=''></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='password' /></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit"
                                       value="submit" /></td>
                </tr>
            </table>

            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />

    </form>
</div>

</body>
</html>