<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/5
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
登录成功，${username}<br>
<script>
    function jumpurl(){
        location='http://www.summerwaves.cn/u/position';
    }
    setTimeout('jumpurl()',3000);
</script>
</body>
</html>
