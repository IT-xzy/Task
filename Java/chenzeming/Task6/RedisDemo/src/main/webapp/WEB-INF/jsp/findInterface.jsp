<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/8/1
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta http-equiv="showProduct" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<form action="${path}/category" method="get">
    <%--<form action="FIND">--%>
    <h1>查询用户</h1>
    <fieldset>
        id ：<input type="text"  name="id" value=""><br/>

        <p id="buttons">
            <input  id="submit" type="submit" value="查询">
        </p>
    </fieldset>
</form>
</body>
</html>
