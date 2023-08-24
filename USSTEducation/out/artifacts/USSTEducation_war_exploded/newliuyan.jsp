<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head> <title>欢迎你${sessionScope.name}</title>
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
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .button1:hover {
            background-color: #4CAF50;
            color: white;
        }
        div.hei{
            position: relative;
           height: 30px;
        }
        div.text1 {
            position:absolute; /* 这里规定输入框的定位类型 */
            right:120px; /* 这里规定输入框于原位置向右偏移300px */
        }
        div.text2
        {
            position:absolute; /* 这里规定输入框的定位类型 */
            right:400px; /* 这里规定输入框于原位置向右偏移300px */
        }
        div.text3 {
            position:absolute; /* 这里规定输入框的定位类型 */
            right:680px; /* 这里规定输入框于原位置向右偏移300px */
        }
        div.tijiao{
            position: absolute;
            right:50px;
        }
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }
        #customers tr:nth-child(even){background-color: #f2f2f2;}
        #customers tr:hover {background-color: #ddd;}
        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
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
        td.price,td.count{
            color: orangered;
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
<form action="SearchServlet" method="post">
    <div class="hei">
        <div class="text1">
        课程：
        <input  type="text" class="text1"  width="50" maxlength="10" name="class" placeholder="Please type the class">
        </div>
        <div class="text3">
            标题：
            <input type="text" class="text3" width="50" maxlength="10" name="ltitle" placeholder="Please type the title">
        </div>
        <div class="text2">
        用户名：
        <input type="text"  class="text2"  width="50" maxlength="10" name="uname" placeholder="Please type the name">
        </div>
        <div class="tijiao">
        <button type="submit" class="btn btn-sm btn-success">查询</button>
    </div>
    </div>


</form>
<form action="StuliuyanServlet" method="post">
<table id="customers">
    <tr>
        <th>Name留言人</th>
        <th>Title留言标题</th>
        <th>Context留言内容</th>
        <th>Time时间</th>
    </tr>
        <c:forEach var="m" items = "${applicationScope.list}" varStatus="status">
            <tr>
                <td>
                    <span>${m.nname}</span>
                </td>
                <td class="price"><a href="SearchServlet?teid=${m.messageId}">${m.ttitle}</a></td>
                <td><span>${m.ccontext} </span></td>
                <td><span>${m.ddate} </span></td>
            </tr>
        </c:forEach>
</table>
    <div class="container1">
            <div class="row">
                <div class="col-25">
                    <label for="ffname">当前用户为</label>
                </div>
                <div class="col-75">
                    <input type="text" class="shangchuan" id="ffname" value="${name}" readonly>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="fname">标题</label>
                </div>
                <div class="col-75">
                    <input type="text" id="fname" class="shangchuan" name="title" placeholder="Your title.."required>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="subject">正文</label>
                </div>
                <div class="col-75">
                    <textarea id="subject" name="content" class="shangchuan" placeholder="Write something.." style="height:200px" required></textarea>
                </div>

            </div>
        <div class="bu1">
            <button type="submit" class="btn btn-lg btn-success">上传</button>
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
