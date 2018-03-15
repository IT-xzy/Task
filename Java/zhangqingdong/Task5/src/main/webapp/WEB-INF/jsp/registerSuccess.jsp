<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/7
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户名为：${username}<br>
密码为:${password}<br>
3秒后转向登录页
<script>
    function jumpurl(){
        location='http://www.summerwaves.cn/login';
    }
    setTimeout('jumpurl()',3000);
</script>
</body>
</html>
