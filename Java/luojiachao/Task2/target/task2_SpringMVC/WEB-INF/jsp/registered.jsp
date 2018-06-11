<%--
  Created by IntelliJ IDEA.
  User: luojiac
  Date: 2018/4/14
  Time: 下午4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-image:url(/images/Alujpg.jpg);background-size: 1440px">
<div style="text-align:center">
    hhh springmvc
</div>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<form  action="/regist" class="form-horizontal" role="form" method="post">
<table align='center' border='1' cellspacing='0'>

    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">username</label>
        <div class="col-sm-2">
            <input type="text"  class="form-control" name="username" id="username" VALUE=""
                   placeholder="输入用户名">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">password</label>
        <div class="col-sm-2">
            <input type="password" class="form-control" name="password" id="password"  VALUE=""
            placeholder="输入密码">
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">email</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="email" name="email"
                   VALUE="" placeholder="输入邮箱">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button onClick="return fun()" >注册</button>
            <script>
                function fun(){
                    alert("注册成功")
                }
            </script>
        </div>

    </div>
</table>
</form>
<form  action="${pageContext.request.contextPath}/index.jsp"  class="col-sm-offset-2 col-sm-10" role="form" method="get">

    <button type="submit" class="btn btn-default">返回首页</button>

</form>
</body>
</html>
