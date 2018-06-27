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
<%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
<%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
<%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<%--<form  action="/regist" class="form-horizontal" role="form" method="post">--%>
<%--<table align='center' border='1' cellspacing='0'>--%>

    <%--<div class="form-group">--%>
        <%--<label for="username" class="col-sm-2 control-label">*username</label>--%>
        <%--<div class="col-sm-2">--%>
            <%--<input type="text"  class="form-control" name="username" id="username" VALUE=""--%>
                   <%--placeholder="输入用户名：8-16位英文字母">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<label for="password" class="col-sm-2 control-label">*password</label>--%>
        <%--<div class="col-sm-2">--%>
            <%--<input type="password" class="form-control" name="password" id="password"  VALUE=""--%>
            <%--placeholder="输入密码">--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="form-group">--%>
        <%--<label for="email" class="col-sm-2 control-label">*email</label>--%>
        <%--<div class="col-sm-2">--%>
            <%--<input type="text" class="form-control" id="email" name="email"--%>
                   <%--VALUE="" placeholder="输入邮箱">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<label for="name" class="col-sm-2 control-label">*name</label>--%>
        <%--<div class="col-sm-2">--%>
            <%--<input type="text" class="form-control" id="name" name="name"--%>
                   <%--VALUE="" placeholder="输入姓名">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<label for="sex" class="col-sm-2 control-label">sex</label>--%>
        <%--<div class="col-sm-2">--%>
            <%--<input type="text" class="form-control" id="sex" name="sex"--%>
                   <%--VALUE="" placeholder="输入性别">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<label for="introduce" class="col-sm-2 control-label">*introduce</label>--%>
        <%--<div class="col-sm-2">--%>
            <%--<input type="text" class="form-control" id="introduce" name="introduce"--%>
                   <%--VALUE="" placeholder="输入个人简介">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<label for="status" class="col-sm-2 control-label">*status</label>--%>
        <%--<div class="col-sm-2">--%>
            <%--<input type="text" class="form-control" id="status" name="status"--%>
                   <%--VALUE="" placeholder="输入在学状态">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<label for="major" class="col-sm-2 control-label">major</label>--%>
        <%--<div class="col-sm-2">--%>
            <%--<input type="text" class="form-control" id="major" name="major"--%>
                   <%--VALUE="" placeholder="输入主修">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<label for="classes" class="col-sm-2 control-label">classes</label>--%>
        <%--<div class="col-sm-2">--%>
            <%--<input type="text" class="form-control" id="classes" name="classes"--%>
                   <%--VALUE="" placeholder="输入课程">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<label for="QQ" class="col-sm-2 control-label">QQ</label>--%>
        <%--<div class="col-sm-2">--%>
            <%--<input type="text" class="form-control" id="QQ" name="QQ"--%>
                   <%--VALUE="" placeholder="输入QQ">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<div class="col-sm-offset-2 col-sm-10">--%>
            <%--<button onClick="return fun()" >注册</button>--%>
            <%--<script>--%>
                <%--function fun(){--%>
                    <%--alert("hello")--%>
                <%--}--%>
            <%--</script>--%>
        <%--</div>--%>

    <%--</div>--%>
                    <%--if(${confirm}){--%>
                        <%--alert("注册成功");--%>
                        <%--window.location.href = "${pageContext.request.contextPath}/index.jsp";--%>
                    <%--}else{--%>
                        <%--alert("注册失败");--%>
                        <%--window.location.href = "${pageContext.request.contextPath}/registered.jsp";--%>
                    <%--};--%>
                <%--}--%>

<%--</table>--%>
<%--</form>--%>
<form action="${pageContext.request.contextPath}/regist" class="form-horizontal" role="form" method="post">
    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">*username</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="username" name="username"
                    placeholder="用户名：8-16位英文数字">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">*password</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="password" name="password"
                    placeholder="输入密码">
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">*email</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="email" name="email"
                     placeholder="输入邮箱">
        </div>
    </div>
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">*name</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="name" name="name"
                    placeholder="输入姓名">
        </div>
    </div>
    <%--<div class="form-group">--%>
        <%--<label for="sex" class="col-sm-2 control-label">sex</label>--%>
        <%--<div class="col-sm-2">--%>
            <%--<input type="text" class="form-control" id="sex" name="sex"--%>
                   <%--VALUE="" placeholder="输入性别">--%>
        <%--</div>--%>
    <%--</div>--%>
    <div class="form-group">
        <label for="introduce" class="col-sm-2 control-label">*introduce</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="introduce" name="introduce"
                    placeholder="输入个人介绍">
        </div>
    </div>
    <div class="form-group">
        <label for="status" class="col-sm-2 control-label">*status</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="status" name="status"
                    placeholder="输入在学状态">
        </div>
    </div>
    <div class="form-group">
        <label for="major" class="col-sm-2 control-label">major</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="major" name="major"
                   placeholder="输入主修">
        </div>
    </div>
    <div class="form-group">
        <label for="classes" class="col-sm-2 control-label">classes</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="classes" name="classes"
                    placeholder="输入课程">
    </div>
    </div>
    <div class="form-group">
        <label for="QQ" class="col-sm-2 control-label">QQ</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="QQ" name="QQ"
                    placeholder="输入QQ">
        </div>
    </div>
    <div>
    <input type="submit" name="提交">
    </div>
</form>

<form  action="${pageContext.request.contextPath}/index.jsp"  class="col-sm-offset-2 col-sm-10" role="form" method="get">

    <button type="submit" class="btn btn-default">返回首页</button>

</form>
</body>
</html>
