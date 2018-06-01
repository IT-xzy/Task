<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/14
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>添加用户</h1>
<form action="${pageContext.request.contextPath}/regist"  method="post">
    姓名：<input type="text" name="name"><br>
    密码：<input type="password" name="password"/><br/><br/>
    <%--密码确认<input type="password" name="password1"/><br/><br/>--%>
    手机号码：<input type="text" name="phone"><br>
    <p id="buttons" >
        <input  type="submit"  value="注册">
    </p>
</form>

</body>
</html>

