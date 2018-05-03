<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 4/17
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这里是增加</title>
</head>
<body>
<form action="/user/result" method="post">
        姓名：    <input type="text" name="name"><br>
        性别：    <input type="text" name="sex"><br>
        QQ ：     <input type="text" name="qq"><br>
        修真类型：<input type="text" name="type"><br>
        何时入学：<input type="text" name="admission"><br>
        线上学号：<input type="text" name="graduate"><br>
        日报链接：<input type="text" name="link"><br>
        立愿：    <input type="text" name="wish"><br>
        辅导师兄：<input type="text" name="audit"><br>
        何处了解：<input type="text" name="understand"><br>
    <a href="/add" >
        <input type="submit" value="增加">
    </a>
</form>
<a href="/">
    <input type="reset" value="取消">
</a>

</body>
</html>
