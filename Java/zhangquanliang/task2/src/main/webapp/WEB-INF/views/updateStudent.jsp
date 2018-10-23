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
</head>
<body>
<form action="${pageContext.request.contextPath}/student" method="post">
    <!-- 将POST请求转化为PUT请求 -->
    <input type="hidden" name="_method" value="PUT"/>
    <input type="hidden" name="id" value="${s.id}"/>
    <input type="hidden" name="startTime" value="${s.startTime}"/>
    <input type="hidden" name="createAt" value="${s.createAt}">
    <input type="hidden" name="updateAt" value="<%=System.currentTimeMillis()%>"/>
    <table>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name" value="${s.name}"></td>
        </tr>
        <tr>
            <td>QQ：</td>
            <td><input type="text" name="qq" value="${s.qq}"></td>
        </tr>
        <tr>
            <td>修真类型：</td>
            <td><input type="text" name="profession" value="${s.profession}"></td>
        </tr>
        <tr>
            <td>毕业院校：</td>
            <td><input type="text" name="graduatedFrom" value="${s.graduatedFrom}"></td>
        </tr>
        <tr>
            <td>学号：</td>
            <td><input type="number" name="onlineId" value="${s.onlineId}"></td>
        </tr>
        <tr>
            <td>日报链接：</td>
            <td><input type="url" name="dailyLink" value="${s.dailyLink}"></td>
        </tr>
        <tr>
            <td>立愿：</td>
            <td><input type="text" name="wish" value="${s.wish}"></td>
        </tr>
        <tr>
            <td>辅导师兄：</td>
            <td><input type="text" name="counselor" value="${s.counselor}"></td>
        </tr>
        <tr>
            <td>从哪里知道修真院：</td>
            <td><input type="text" name="way" value="${s.way}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="ok" value="确认修改"></td>
        </tr>
    </table>

</form>
</body>
</html>
