<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示信息进行修改</title>
</head>
<body align="center">
添加：
<br><form action="/infovalida" method="post"   enctype="multipart/form-data"<%--align="center"--%> >
    账号:<input type="text" name="account" ><br>
    密码:<input type="password" name="password" ><br>
    手机号码:<input type="text" name="telephone" ><br>
    <input type="submit" value="获取验证码" formaction="/phonenum" formmethod="post" /><br>
    手机验证码:<input type="text" name="vcode" ><br>
    邮箱:<input type="text" name="email" ><br>
    <input type="submit" value="获取验证码" formaction="/emailvcode" formmethod="post" /><br>
    邮箱验证码:<input type="text" name="ecode" ><br>
    <p>
        <label for="file">文件：</label><br>
        <input type="file" name="file" id="file" multiple="multiple" />
    </p>
    <p>
    <input type="submit" value="提交">
</form><br>
<a href="/welcome">返回主页</a>
</body>
</html>
