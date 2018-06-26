<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/4/7
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="text-align: center">
        <form action="/land" method="get">
            <input type="submit" value="登录"/>
        </form>
        <form action="/register/ppage" method="get">
            <input type="submit" value="手机注册"/>
        </form>
        <form action="/register/epage" method="get">
            <input type="submit" value="邮箱注册"/>
        </form>
        <form action="/migration/qiniu" method="post">
            <input type="submit" value="七牛 >>> 阿里云OSS"/>
        </form>
        <form action="/migration/aliyun" method="post">
            <input type="submit" value="阿里云OSS >>> 七牛"/>
        </form>
    </div>
</body>
</html>
