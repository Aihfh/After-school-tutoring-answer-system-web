<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <style>
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
        body{
            background-image:url("img/hun.jpg");
            background-position: center;
        }
        .center {
            padding: 70px;
            text-align: center;
        }
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 6px 12px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
            cursor: pointer;
        }

        .button3 {
            background-color: white;
            color: black;
            border: 1px solid #f44336;
        }

        .button3:hover {
            background-color: #f44336;
            color: white;
        }
        .row:after {
            content: "";
            display: table;
            clear: both;
        }
        .container {
            border-radius: 5px;
            padding: 20px;
        }
        input[type=text], select, textarea {
            width: 10%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }
    </style>

</head>

<body>
<div class="center">
    <div class="container">
        <form action="LoginServlet" method="get">
            <h3 style="color: #8a6d3b">登录信息错误，请核验后重新输入</h3>
            <br>
            <div class="row">
                <button type="submit" class="button button3" >返回登录</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>