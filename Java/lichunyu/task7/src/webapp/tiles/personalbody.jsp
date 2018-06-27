<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-6-11
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
    body{
    margin:0;
    background-color: #6fee64;
    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
    background-size: 100%;
    text-align: center;
    color:  #0000ff ;
    }
    </style>
    <title>个人主页</title>
</head>
<body>
<div >
    <div>
        <div>
            <p>个人头像</p>
            <p><img src="${user.code}" alt="头像"></p>
        </div>
        <div>
            <form action="/u/photo" method="get">
                <button type="submit" >上传头像</button>
            </form>
        </div>
    </div>
    <div >
        <p>姓名:${user.name}</p>
        <p>扣扣:${user.qq}</p>
        <p>邮箱:${user.email}</p>
        <p>手机:${user.phoneNum}</p>
    </div>
</div>

</body>
</html>
