<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/14
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
修改用户
<form action="${pageContext.request.contextPath}/u/user" method="post" >
    <input type="hidden" name="_method" value="PUT"/><br>
    id：<input type="text" name="id" value="${user.id}" /><br>
    姓名：<input type="text" name="name" value="${user.name}" /><br>
    密码：<input type="password" name="password" value="${user.password}" /><br>
    <input type="submit"  value="修改">
</form>

<form action="${pageContext.request.contextPath}/u/users"  >
    <%--<input type="hidden" name="_method" value="PUT"/><br>--%>
    <input type="submit"  value="登出">
    </form>
</body>
</html>
