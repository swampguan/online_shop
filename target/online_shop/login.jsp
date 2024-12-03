<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>


    <title>用户登录</title>
    <link rel="stylesheet" href="<c:url value="/css/login.css"/>">



</head>
<body class="motif" style="background-color: rgb(226, 229, 231)">
<div class="login" style="text-align: center; margin:0 auto">
    <h1>用户登录</h1><br><br>
    <form action="loginServlet" method="post">
        <table style="margin: 0 auto;">
            <tr>
                <td >
                    <label for="username">用户名:</label>
                </td>
                <td>
                    <input type="text" id="username" name="username" required>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="password">密码:</label>
                </td>
                <td>
                    <input type="password" id="password" name="password" required>
                </td>
            </tr>
        </table>
        <br>

        <input type="submit" value="登录">
    </form>
    <br>
    <p>还没有账户? 现在 <a href="register.html" style="text-decoration: none;color:#00a4ff; ">注册</a> </p>
</div>

</body>
</html>
