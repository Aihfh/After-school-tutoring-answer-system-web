<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
  <style>
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
      padding: 16px 32px;
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
      border: 2px solid #f44336;
    }

    .button3:hover {
      background-color: #f44336;
      color: white;
    }
    .col-1 {
      color: #8a6d3b;
      width: 78%;
      margin-top: 6px;
      font-style: oblique;
    }
    .col-2 {
      width: 150%;
      margin-top: 25px;
      margin-left: -210px;
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
    <form action="LoginServlet" method="post">
      <h1 style="color: #8a6d3b">留言本登录</h1>
      <div class="row">
        <div class="col-1">
          <label for="name1">请输入您的用户名:</label>
        </div>
        <div class="col-2">
          <input type="text"  width="100" maxlength="10" id="name1" name="name" placeholder="Please type your name">
        </div>
      </div>
      <br>
      <div class="row">
        <button type="submit" class="button button3" >提交</button>
      </div>
    </form>
  </div>
</div>
</body>
</html>