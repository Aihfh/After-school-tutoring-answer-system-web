
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <title>欢迎你${sessionScope.name}</title>
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
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="Tmainview.jsp">欢迎你${sessionScope.name}老师</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人信息 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="TinfoServlet">查看个人信息</a></li>

                    </ul>
                </li>
                <li><a href="TclassServlet">查看课程情况</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">留言信息查看 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="TAllliuyanServlet">查看留言板</a></li>
                        <li><a href="TcheckselfanswerServlet">我的回答</a></li>
                    </ul>
                </li>
                <li class="active"><a href="Login1.jsp">返回登录</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container theme-showcase" role="main">
    <div class="jumbotron">
        <h1>Theme example</h1>
        <p>This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.</p>
    </div>
    <div class="page-header">
        <h1>Buttons</h1>
    </div>
    <p>
        <button type="button" class="btn btn-lg btn-default">Default</button>
        <button type="button" class="btn btn-lg btn-primary">Primary</button>
        <button type="button" class="btn btn-lg btn-success">Success</button>
        <button type="button" class="btn btn-lg btn-info">Info</button>
        <button type="button" class="btn btn-lg btn-warning">Warning</button>
        <button type="button" class="btn btn-lg btn-danger">Danger</button>
    </p>
    <div class="page-header">
        <h1>Tables</h1>
    </div>
    <div class="row">
        <div class="col-md-6">
            <table class="table">
                <thead>
                <tr>
                    <th>1</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-md-6">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>2</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Larry</td>
                    <td>the Bird</td>
                    <td>@twitter</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="page-header">
        <h1>Labels</h1>
    </div>
    <h1>
        <span class="label label-default">Default</span>
        <span class="label label-primary">Primary</span>
        <span class="label label-success">Success</span>
        <span class="label label-info">Info</span>
        <span class="label label-warning">Warning</span>
        <span class="label label-danger">Danger</span>
    </h1>
    <h2>
        <span class="label label-default">Default</span>
        <span class="label label-primary">Primary</span>
        <span class="label label-success">Success</span>
        <span class="label label-info">Info</span>
        <span class="label label-warning">Warning</span>
        <span class="label label-danger">Danger</span>
    </h2>

    <div class="page-header">
        <h1>Badges</h1>
    </div>
    <p>
        <a href="#">Inbox <span class="badge">42</span></a>
    </p>
    <ul class="nav nav-pills" role="tablist">
        <li role="presentation" class="active"><a href="#">Home <span class="badge">42</span></a></li>
        <li role="presentation"><a href="#">Profile</a></li>
        <li role="presentation"><a href="#">Messages <span class="badge">3</span></a></li>
    </ul>

    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Project name</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li class="dropdown-header">Nav header</li>
                            <li><a href="#">Separated link</a></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="page-header">
        <h1>Alerts</h1>
    </div>
    <div class="alert alert-success" role="alert">
        <strong>Well done!</strong> You successfully read this important alert message.
    </div>
    <div class="alert alert-info" role="alert">
        <strong>Heads up!</strong> This alert needs your attention, but it's not super important.
    </div>
    <div class="alert alert-warning" role="alert">
        <strong>Warning!</strong> Best check yo self, you're not looking too good.
    </div>
    <div class="alert alert-danger" role="alert">
        <strong>Oh snap!</strong> Change a few things up and try submitting again.
    </div>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.29/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
