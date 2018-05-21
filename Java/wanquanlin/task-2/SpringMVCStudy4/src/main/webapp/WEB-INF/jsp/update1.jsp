<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/15
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示信息进行修改</title>
</head>
<body>
对ID为${student.ID}的数据进行修改：<br>
<br><form action="${pageContext.request.contextPath}/user/student/${student.ID}" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    姓名:<br><input type="text" name="name" value="${student.name}"><br>
    QQ:<br><input type="text" name="QQ" value="${student.QQ}"><br>
    onlineID:<br><input type="text" name="onlineID" value="${student.onlineID}"><br>
    time_of_enrollment:<br><input type="date" name="time_of_enrollment" value="${student.time_of_enrollment}"><br>
    graduate_institutions:<br><input type="text" name="graduate_institutions"  value="${student.graduate_institutions}"><br>
    report_link:<br><input type="text" name="report_link"  value="${student.report_link}"><br>
    hearfrom:<br><input type="text" name="hearfrom"  value="${student.hearfrom}"><br>

    <input type="submit" value="提交" method="post">
</form><br>
<a href="/index.jsp">返回主页</a>
</body>
</html>

