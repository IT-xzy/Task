<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/13
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  action="${ctx}/student" method="post">
    用户名<input type="text" name="name" />
    <br/>
    QQ<input type="text" name="QQ"/>
    <br/>
    类型：<input type="radio" checked="checked" name="type" value="CSS"/>CSS
    <input type="radio" name="type"  value="JAVA" />JAVA
    <input type="radio" name="type"  value="PM" />PM
    <br>
    入学时间<input type="text" name="appointment" />
    <br/>
    毕业学校<input type="text" name="school"/>
    <br/>
    学号<input type="text" name="number"/>
    <br/>
    日报链接<input type="text" name="link"/>
    <br/>
    立愿<input type="text" name="oath"/>
    <br/>
    辅助师兄<input type="text" name="supportSenior"/>
    <br/>
    推荐师兄<input type="text" name="referrer"/>
    <br/>
    来源<input type="text" name="source"/>
    <br/>
    <%--    性别:  男<input type="radio" checked="checked" name="sex" value="M"/>
        女<input type="radio" name="sex"  value="F" /><br>--%>
    <input type="submit" name="注册" value="添加学员">
</body>
</html>
