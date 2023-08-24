<%--
  Created by IntelliJ IDEA.
  User: 56997
  Date: 2021/12/29
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .auth_icon_user {
            background: url("/img/user.jpg") no-repeat 8px 8px;
            background-size: 50% 50%;
        }
        .auth_icon_pwd {
            background: url("/img/password.jpg") no-repeat 8px 8px;
            background-size: 50% 50%;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta content="width=device-width,initial-scale=0.8, minimum-scale=0.8, maximum-scale=3"
          name="viewport"/>
    <meta name="renderer" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta property="qc:admins" content="754034015366713545637571540352652"/>
    <meta property="wb:webmaster" content="1ad39047f32b5b6b"/>
    <title>统一身份认证</title>
</head>
<script>
</script>
<link href="css/Edu1.css" rel="stylesheet">
<link href="css/Edu2.css" rel="stylesheet">
<script type="text/javascript">
    var secure = "true";
</script>
<body onload="loadFresh();">

<div class="auth_page_wrapper">

    <div class="auth_login_content">
        <img class="mainbg" src="${pageContext.request.contextPath}/img/dzbg.jpg" alt="bg" />
        <div class="auth_login_left">
            <div class="auth_logo">
                <img src="${pageContext.request.contextPath}/img/dzlogo.png" alt="logo"/>
            </div>
            <div class="auth_others">

            </div>

            <div class="auth_tab">
                <div class="auth_tab_links">
                    <ul>
                        <li id="accountLogin"  class="selected" tabid="01"><span>账号登录</span></li>
                    </ul>
                </div>
                <div class="clearfloat"></div>
                <div class="auth_tab_content">
                    <div tabid="01" class="auth_tab_content_item">
                        <form id="casLoginForm" class="fm-v clearfix amp-login-form" role="form" action="LoginServlet" method="post">
                            <p>
                                <i class="auth_icon auth_icon_user"></i>
                                <input type="text" class="auth_input" id="username" name="name" placeholder="Please type your name"  required>
                                <span id="usernameError" style="display:none;" class="auth_error">请输入用户名</span>
                            </p>
                            <p>
                                <i class="auth_icon auth_icon_pwd"></i>
                                <input id="password" class="auth_input" name="password" placeholder="Please type your password"  type="password" required>
                                <span id="passwordError" style="display:none;" class="auth_error">请输入密码</span>
                            </p>
                            <p id="cpatchaDiv">
                            </p>
                            <p style="height: 20px;">
                                <a id="getBackPasswordMainPage" href="Uregister.jsp" class="auth_login_forgetp">
                                    <small>新用户注册</small>
                                </a>
                            </p>
                            <p>
                                <button type="submit" class="auth_login_btn primary full_width">登录
                                </button>
                            </p>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <div class="clearfloat"></div>

</div>
</body>

</html>