<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/7
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="showProduct" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>

<body>

    <h1>用户信息</h1>
    <form action="/insert">
    <fieldset>
            <input  type="submit" value="添加用户">
        </p>
    </fieldset>
</form>

    <form action="/delete">
        <fieldset>
            <input  type="submit" value="删除用户">
            </p>
        </fieldset>
    </form>

    <form action="/updateUser">
        <fieldset>
            <input  type="submit" value="修改用户">
            </p>
        </fieldset>
    </form>

    <form action="/find">
        <fieldset>
            <input  type="submit" value="查询用户">
            </p>
        </fieldset>
    </form>

    <form action="/all">
        <fieldset>
            <input  type="submit" value="查询全部">
            </p>
        </fieldset>
    </form>

</body>
</html>
