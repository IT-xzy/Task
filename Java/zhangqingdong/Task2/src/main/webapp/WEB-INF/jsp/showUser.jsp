<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: summerwaves
  Date: 2017/9/18
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>用户详细信息</title>
</head>
<body>
    学员名：${student.name} </br>
    QQ: ${student.QQ} </br>
    类型 : ${student.type}</br>
    入学时间: ${student.appointment} </br>
    毕业学校: ${student.school} </br>
    学号: ${student.number} </br>
    日报链接: ${student.link} </br>
    立愿: ${student.oath} </br>
    辅助师兄: ${student.supportSenior} </br>
    推荐师兄: ${student.referrer} </br>
    来源: ${student.source} </br>
<form action="${ctx}/student/modify" method="get">
    <input type="submit" value="修改信息">
</form>

</body>
</html>
