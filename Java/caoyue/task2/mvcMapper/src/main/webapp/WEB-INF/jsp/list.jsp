<%--
  Created by IntelliJ IDEA.
  User: caoyue
  Date: 2018/3/30
  Time: 下午4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示找到的数据条</title>
</head>
<body>
<table width="60%" border="1" cellpadding="2" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>QQ</th>
        <th>onlineNumber</th>
        <th>enrollmentTime</th>
        <th>professionType</th>
        <th>dailyLink</th>
        <th>promise</th>
        <th>brotherName</th>
    </tr>
    <tr>
        <td>${student.ID }</td>
        <td>${student.name }</td>
        <td>${student.QQ}</td>
        <td>${student.onlineNumber}</td>
        <td>${student.enrollmentTime}</td>
        <td>${student.professionType}</td>
        <td>${student.dailyLink}</td>
        <td>${student.promise}</td>
        <td>${student.brotherName}</td>
        <td><form action="/user/list/one" method="get">
            <input type="hidden" name="ID" value="${student.ID }">
            <input type="submit" value="更新">
        </form> </td>
        <td><form action="${pageContext.request.contextPath}/user/student/${student.ID}" method="post">
            <input type="hidden" name="_method" value="DELETE">
            <input type="submit" value="删除">
        </form></td>
    </tr>
</table><br>
</form><br>
<a href="/index.jsp">返回</a>
</body>
</html>
