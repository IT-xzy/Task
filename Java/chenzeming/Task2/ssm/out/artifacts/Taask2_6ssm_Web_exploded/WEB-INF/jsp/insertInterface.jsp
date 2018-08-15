<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/7
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="showProduct" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<%--<form action="/INSERT">--%>
    <form action="${pageContext.request.contextPath}/category" method="post">
    <h1>添加用户</h1>
    <fieldset>
        学号 ：    <input type="text"  id="id"    name="id" value=""><br/>
        姓名 ：    <input type="text"  id="name"  name="userName" value=""><br/>
        年龄 ：    <input type="text"  id="age"   name="age" value=""><br/>
        体重 ：    <input type="text"  id="weight" name="weight" value=""><br/>
        create_at:<input type="text" id="create_at" name="createAt" value=""><br/>
        update_at:<input type="text" id="updata_at" name="updateAt" value=""><br/>
        <%--<p id="buttons">--%>
            <input  id="submit" type="submit" value="添加">
        <%--</p>--%>
    </fieldset>
</form>
</body>
</html>
