<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: suger
  Date: 2018/10/3
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
    <title>修改学生信息</title>
    <style>
        label {display:inline-block; width: 10em; margin-right: 1em; text-align: right; }
    </style>

</head>
<body>
<form action="${pageContext.request.contextPath}/student" method="post">
    <!-- 将POST请求转化为PUT请求 -->
    <input type="hidden" name="_method" value="PUT"/>
    <input type="hidden" name="id" value="${s.id}"/>
    <input type="hidden" name="startTime" value="${s.startTime}"/>
    <input type="hidden" name="createAt" value="${s.createAt}">
    <input type="hidden" name="updateAt" value="<%=System.currentTimeMillis()%>"/>

    <label>姓名：</label><input type="text" name="name" value="${s.name}"/>
    <br/>
    <label>QQ：</label><input type="text" name="qq" value="${s.qq}"/>
    <br/>
    <label>修真类型：</label><input type="text" name="profession" value="${s.profession}"/>
    <br/>
    <label>毕业院校：</label><input type="text" name="graduatedFrom" value="${s.graduatedFrom}"/>
    <br/>
    <label>学号：</label><input type="text" name="onlineId" value="${s.onlineId}"/>
    <br/>
    <label>日报连接：</label><input type="url" name="dailyLink" value="${s.dailyLink}"/>
    <br/>
    <label>立愿：</label><input type="text" name="wish" value="${s.wish}"/>
    <br>
    <label>辅导师兄：</label><input type="text" name="counselor" value="${s.counselor}"/>
    <br/>
    <label>从哪里知道修真院：</label><input type="text" name="way" value="${s.way}"/>
    <br/>
    <label></label><input type="submit" name="ok" value="确认修改"/>

</form>
</body>
</html>
