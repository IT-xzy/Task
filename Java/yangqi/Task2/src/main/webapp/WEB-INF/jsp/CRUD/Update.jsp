<%@ taglib prefix="date" uri="/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Yzzzt
  Date: 2018/5/25
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/rest/${itemsList.id}" method="POST">
    <table width="100%" border=1>
        <tr>
            <td>id</td>
            <td>名字</td>
            <td>QQ</td>
            <td>修真类型</td>
            <td>预计入学时间</td>
            <td>毕业学校</td>
            <td>学院学号</td>
            <td>日报连接</td>
            <td>愿望</td>
            <td>线上师兄</td>
            <td>从哪了解到</td>
            <td>操作</td>
        </tr>

        <tr>
            <td>${itemsList.id }</td>
            <td><input type="text" name="name" style="width: 80px;" value="${itemsList.name }"></td>
            <td><input type="text" name="QQ" style="width: 100px;" value="${itemsList.QQ }"></td>
            <td><input type="text" name="major" style="width: 100px;" value="${itemsList.major }"></td>
            <td><input type="text" name="startTime" value="<date:date value ="${itemsList.startTime }"/>"></td>
            <td><input type="text" name="school" style="width: 120px;" value="${itemsList.school }"></td>
            <td><input type="text" name="student_Id" style="width: 65px;" value="${itemsList.student_Id}"/></td>
            <td><input type="text" name="daily_cone" value="${itemsList.daily_cone }"></td>
            <td><input type="text" name="desire" value="${itemsList.desire}"></td>
            <td><input type="text" name="bre" style="width: 65px;" value="${itemsList.bre }"></td>
            <td><input type="text" name="know_from" style="width: 80px;" value="${itemsList.know_from }"></td>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
