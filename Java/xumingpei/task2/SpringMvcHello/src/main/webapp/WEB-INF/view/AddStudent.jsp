<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/2/24
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>添加页面</title>
</head>
<body>
<div style="text-align:center;margin-top:40px">
    <form method="post" action="/students">
        名字：    <input name="name"  type="text"> <br><br>
        qq:      <input name="qq"  type="text"> <br><br>
        修真类型：<input name="type"  type="text"> <br><br>
        入学时间：<input name="enrolmentTime"  type="text"> <br><br>
        毕业院校：<input name="school"  type="text"> <br><br>
        线上学号：<input name="onlineId"  type="text"> <br><br>
        日报连接：<input name="dailyUrl"  type="text"> <br><br>
        入门誓言：<input name="wish"  type="text"> <br><br>
        入门师兄：<input name="brother"  type="text"> <br><br>
        了解渠道：<input name="whereToKnowJnshu"  type="text"> <br><br>
        创建时间：<input name="createAt" value="<%=System.currentTimeMillis()%>" type="hidden"> <br><br>
        更新时间：<input name="updateAt" value="<%=System.currentTimeMillis()%>" type="hidden"> <br><br>
        <input type="submit" value="增加分类">
    </form>
</div>
</body>
</html>
