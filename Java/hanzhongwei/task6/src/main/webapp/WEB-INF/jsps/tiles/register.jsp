<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/5/24
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="css/task8.css"/>


<div style="width:500px;margin:0px auto;text-align:center">


    <div style="text-align:center;margin-top:40px">
        <h2 align="center">注册界面</h2>
        <form method="post" action="/register">
            <input type="hidden" name="_method" value="POST">
            学员资料：<br><br>
            用户名：<input name="userName" value="" type="text"> <br><br>
            密&nbsp;码：<input name="password" value="" type="text"> <br><br>
            <input type="submit" value="用户注册" onclick='return confirm("确认要注册么?");'>
        </form>
    </div>
</div>
