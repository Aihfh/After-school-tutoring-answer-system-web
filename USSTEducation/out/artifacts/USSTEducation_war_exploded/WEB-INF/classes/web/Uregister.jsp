<%--
  Created by IntelliJ IDEA.
  User: 56997
  Date: 2021/10/14
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$用户信息填写$</title>
</head>
<body>
<form action="URegisterServlet" method="post">
    <table>

            <h3>用户注册:</h3>
            <p>学号：<input type="text" name="Uno" size="20" placeholder="请输入学号" required></p>
            <p>用户名：<input type="text" name="Uname" size="20" placeholder="请输入用户名" required></p>
            <p>用户密码： <input type="text" name="Upass" size="20" placeholder="请输入密码" required ></p>
            <p>真实姓名： <input type="text" name="Tname" size="20" placeholder="请输入真实的姓名" required></p>

    </table>
    <button type="submit" class="button button3" >提交</button>
</form>
</body>
</html>
