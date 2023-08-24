<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/11/6
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.bean.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static com.sun.tools.attach.VirtualMachine.list" %>
<%@ page import="Util.DBmeUtil" %>
<html>
<head>
    <title>Title</title>
    <style>

        .center {
            padding: 70px 0;
            text-align: center;
        }
        body{
            background-image: url("img/cha2.jpg");
            background-position: 100%,100%;
        }
    </style>
</head>
<body>
<% ArrayList<Message> list = (ArrayList<Message>)application.getAttribute("list");
    String id = request.getParameter("id");
    int idd=Integer.parseInt(id);
    int i = 0;
    for (Message message:list){
        if (i!=idd)
            i++;
        else{
%>
<div class="center">
    <div>
        <h4>留言人姓名:<%=message.getNname()%></h4>
    </div>
    <div>
        <h4>留言标题：<%=message.getTtitle()%></h4>
    </div>
    <div>
        <h4>留言内容：<%=message.getCcontext()%></h4>
    </div>
    <div>
        <h4>留言时间：<%=message.getDdate()%></h4>
    </div></div>
<% break;}%>
<%}%>
<a href="liuyanban.jsp" style="display: block;text-align: right">返回留言本</a>
</body>
</html>