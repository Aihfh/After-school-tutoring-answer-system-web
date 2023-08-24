<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/theme/">
    <title>Theme Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/examples/theme/theme.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="studentmain.jsp">欢迎你${sessionScope.name}</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人信息 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="StudentinfoServlet">查看个人信息</a></li>

                    </ul>
                </li>
                <li><a href="ClassselectServlet">查看课程情况</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">留言信息查看 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="AllliuyanServlet">查看留言板</a></li>
                        <li><a href="StucheckselfServlet">我的留言</a></li>
                    </ul>
                </li>
                <li class="active"><a href="Login1.jsp">返回登录</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="page-header">
    <h1>个人信息</h1>
</div>
<c:forEach var="m" items="${applicationScope.uinfo}" varStatus="status">
<div class="alert alert-success" role="alert">
    <strong>学号：</strong>${m.userid}
</div>
<div class="alert alert-info" role="alert">
    <strong>用户名：</strong> ${m.UName}<span><a type="button" class="btn btn-xs btn-warning"  href="StudentinfochangeServlet?usid=${m.userid}">修改</a></span>
</div>
    <div class="alert alert-warning" role="alert">
        <strong>密码：</strong>${m.UPassword}<span><a type="button" class="btn btn-xs btn-warning" href="StudentinfochangeServlet?usid=${m.userid}">修改</a></span>
    </div>
<div class="alert alert-danger" role="alert">
    <strong>真实姓名：</strong>${m.truename}
</div>
</c:forEach>

<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
