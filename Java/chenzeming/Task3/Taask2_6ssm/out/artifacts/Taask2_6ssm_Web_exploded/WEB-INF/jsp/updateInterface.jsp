<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/7
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="showProduct" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<%--<form action="/UPDATE">--%>
<form action="/category" method="post">
    <input type="hidden" name="_method" value="PUT">
    <h1>修改用户</h1>
    <fieldset>
        学号 ：    <input type="text"  id="id"    name="id" value=""><br/>
        姓名 ：    <input type="text"  id="name"  name="userName" value=""><br/>
        年龄 ：    <input type="text"  id="age"   name="age" value=""><br/>
        体重 ：    <input type="text"  id="weight" name="weight" value=""><br/>
        update_at:<input type="text" id="updata_at" name="updateAt" value="">
        <%--<p id="buttons">--%>
            <input  id="submit" type="submit" value="修改">
        <%--</p>--%>
    </fieldset>
</form>
</body>
</html>