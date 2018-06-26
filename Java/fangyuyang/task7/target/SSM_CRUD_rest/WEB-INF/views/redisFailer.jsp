<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2018/5/29
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<body>
<style type="text/css">
    a {
        text-decoration: none;
        color: #fff;
        font-size: 14px;
    }
    h3 {
        width: 300px;
        height: 100px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: #14ded8;
        border-radius: 4px;
    }
</style>


<h3>
    <p>多次获取验证码不许多发，半小时后才可以继续</p>
        <form action="${pageContext.request.contextPath}" >
            <input type="submit" value="返回首页">
        </form>
</h3>
</body>
</body>
</html>
