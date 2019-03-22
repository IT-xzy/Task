<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/28
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/registration" method="post">
    <%--<input type="hidden" name="_method" value="PUT">--%>

        <%--<table>--%>
            <%--<tr>--%>
                <%--<td>loginName</td>--%>
                <%--<td><input path="loginName" type="text"/></td>--%>
                <%--<td><errors path="loginName" cssStyle="color: red" /> </td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>password</td>--%>
                <%--<td><input path="pwd" type="password"/></td>--%>
                <%--<td><errors path="pwd" cssStyle="color: red" /> </td>--%>
            <%--</tr>--%>
            <%--<tr><input type="submit" value="注册" ><br></tr>--%>
            <%--<tr><input type="reset" value="重置"></tr>--%>
        <%--</table>--%>
    name : <input type="text" name="loginName"><br>
    password : <input type="password" name="pwd"><br>
    <input type="submit" value="注册" ><br>
    <input type="reset" value="重置">
</form>
</body>
</html>
