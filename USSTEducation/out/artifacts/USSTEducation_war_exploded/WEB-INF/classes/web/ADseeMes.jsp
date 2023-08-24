<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.bean.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static com.sun.tools.attach.VirtualMachine.list" %>
<%@ page import="Util.DBmeUtil" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/theme/">
    <title>Theme Template for Bootstrap</title>
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/examples/theme/theme.css" rel="stylesheet">
    <!--[if lt IE 9]><script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <title>Title</title>
    <style>
        div.tijiao{
            position: absolute;
            right:50px;
        }
        div.chuan{
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;

        }
        .shangchuan{
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;

        }
        .container1 {
            border-radius: 5px;
            background-color: #9acfea;
            padding: 20px;
        }
        .col-25 {
            float: left;
            width: 50%;
            margin-top: 6px;
        }
        .col-75 {
            float: left;
            width: 100%;
            margin-top: 6px;
        }
        .row:after {
            content: "";
            display: table;
            clear: both;
        }
        @media screen and (max-width: 600px) {
            .col-25, .col-75{
                width: 100%;
                margin-top: 0;
            }
        }
        table{
            width: 100%;
            border: 1px solid #ddd;
            padding: 10px;
        }
        h3 {
            text-align: center;
            line-height: 55px;
            font-size: 28px;
            font-weight: normal;
            color: #666;
            position: relative;
        }
        div.bu1{
            position: absolute;
            right: 60px;
        }
    </style>
</head>
<body background="img/ltu4.jpg">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="Tmainview.jsp">欢迎你${sessionScope.name}管理员</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人信息 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="AdminfoServlet">查看个人信息</a></li>
                        <li><a href="AcheckteaServlet">查看教师信息</a></li>

                    </ul>
                </li>
                <li><a href="AclassServlet">查看课程情况</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">留言信息查看 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="ADMAllliuyanServlet">查看留言板</a></li>
                        <li><a href="AdmanswerServlet">查看回答</a></li>
                    </ul>
                </li>
                <li class="active"><a href="Login1.jsp">返回登录</a></li>
            </ul>
        </div>
    </div>
</nav>
<form action="AnswerviewServlet" method="post">
    <div class="container theme-showcase" role="main">
        <div class="jumbotron">
            <h1>留言信息</h1>
            <c:forEach var="q" items = "${applicationScope.QA}" varStatus="status">
                <p>
                <td>Name留言人：${q.nname}</></td>
                <br>
                <td>Title留言标题：${q.ttitle}</td>
                <br>
                <td>Context留言内容：${q.ccontext}</td>
                <br>
                <br>
                <td>Time时间：${q.ddate}</td>
                </p>
            </c:forEach>
        </div>
    </div>
    <div class="container theme-showcase" role="main">
        <div class="jumbotron">
            <h1>回答信息</h1>
            <c:forEach var="A" items = "${applicationScope.A}" varStatus="status">
                <p>
                <td>Name回答教师：${A.tname}</></td>
                <br>
                <td>Picture图片：${A.apicture}</td>
                <br>
                <td>Context留言内容：${A.acontent}</td>
                <br>
                <br>
                <td>Time时间：${A.adate}</td>
                </p>
            </c:forEach>
        </div>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>