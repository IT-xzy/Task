<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>主页</title>
</head>
<h3><center><font color="#dc143c" size="10">主页</font></center></h3>
<body><center>
<h1>---${loginUser}---</h1>
<a href="/add" method="get">新增数据</a>
<a href="/page?SHOW_ITEMS=10&pageNo=1" method="get">查看全部数据</a>
<a href="/find">根据ID查询数据</a>
    <a href="/">退出登录</a>


    <form name="input" action="/json"  method="get">
        <center>输入ID: <input type="number" name="id">
            <input type="submit" value="json"></center>
</center>
<center>Power By Resin</center>
</body>

</html>