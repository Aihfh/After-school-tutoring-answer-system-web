
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import="com.bean.Message" %>
<html>
<head>
    <link href="mybootstrap/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="mybootstrap/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <title>Title</title>
    <style>
        body{
            background-image: url("img/cha1.jpg");
            background-position: left top;
        }
        * {
            box-sizing: border-box;
        }
        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }
        label {
            padding: 12px 12px 12px 0;
            display: inline-block;
        }
        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }
        input[type=submit]:hover {
            background-color: #45a049;
        }
        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
        .col-25 {
            float: left;
            width: 25%;
            margin-top: 6px;
        }
        .col-75 {
            float: left;
            width: 75%;
            margin-top: 6px;
        }
        .row:after {
            content: "";
            display: table;
            clear: both;
        }
        .row1{
            content: "";
            clear: both;
        }
        @media screen and (max-width: 600px) {
            .col-25, .col-75, input[type=submit] {
                width: 100%;
                margin-top: 0;
            }
        }
        table{
            width: 100%;
            border: 1px solid #ddd;
            padding: 10px;
        }
        thead>tr{
            line-height: 45px;
            background-color: #e5e5e5;
        }
        td{
            padding: 0 10px;
            position: relative;
        }
        input[type=checkbox]{
            opacity: 0;
            margin-right: 5px;
            width:18px;
            height: 18px;
        }
        td>img{
            width: 120px;
            vertical-align: middle;
        }
        span.pname{
            color: #0dcaf0;
        }
        td.price,td.count{
            color: orangered;
        }
        #to-checkout>span{
            font-size: 14px;
        }
        h3 {
            text-align: center;
            line-height: 55px;
            font-size: 28px;
            font-weight: normal;
            color: #666;
            position: relative;
        }
        h3:after{
            content: '';
            position: absolute;
            width: 30%;
            height: 2px;
            background-color: green;
            bottom: 0;
            left: 50%;
            margin-left: -15%;
        }
        a:link, a:visited {
            background-color: #f44336;
            color: white;
            position: relative;
            padding: 14px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        a:hover, a:active {
            background-color: red;
        }
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 12px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
            width: 10%;
            float: right;

        }
        .button1 {
            background-color: white;
            color: black;
            border: 2px solid #4CAF50;
        }
        .button1:hover {
            background-color: #4CAF50;
            color: white;
        }

    </style>
</head>
<body>

<tr class="cart">
    <h3 class="title">留言本留言栏</h3>
    <table>
        <thead>
        <tr>
            <td>留言人</td>
            <td>留言标题</td>
            <td>留言内容</td>
        </tr>
        </thead>
        <c:forEach var="m" items = "${list}" varStatus="status">
            <tr>
                <td>
                    <span>${m.nname}</span>
                </td>
                <td class="price"><a href="xiangqing.jsp?id=${status.index}">${m.ttitle}</a></td>
                <td><span>${m.ccontext} </span></td>
            </tr>
        </c:forEach>
    </table>
</tr>
<br>
<br>
<div class="container">
    <form action="LiuyanServlet" method="post" >
        <div class="row">
            <div class="col-25">
                <label for="ffname">当前用户为</label>
            </div>
            <div class="col-75">
                <input type="text" id="ffname" value="${name}" readonly>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="fname">标题</label>
            </div>
            <div class="col-75">
                <input type="text" id="fname" name="title" placeholder="Your title..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="subject">正文</label>
            </div>
            <div class="col-75">
                <textarea id="subject" name="content" placeholder="Write something.." style="height:200px"></textarea>
            </div>
        </div>
        <div class="row1">
            <button type="submit" class="button button1" >上传</button>
        </div>
    </form>
</div>
<br>
<br>
<button></button>
<a href="index.jsp" target="_blank">返回登录</a>
<br>
<br>
</body>
</html>