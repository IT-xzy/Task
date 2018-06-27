<%--
  Created by IntelliJ IDEA.
  User: caoyue
  Date: 2018/4/1
  Time: 下午2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>展示模糊查询结果</title>
</head>
<body>

<table width="60%" border="1" cellpadding="2" cellspacing="0" >
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
        <th>create_at</th>
        <th>update_at</th>
        <th> </th>
        <th> </th>
    </tr>
    <c:forEach items="${listsall}" var="student" >
        <tr>
            <td>${student.ID }</td>
            <td>${student.name }</td>
            <td>${student.QQ}</td>
            <td>${student.onlineNumber}</td>
            <td>${student.enrollmentTime}</td>
            <td>${student.professionType}</td>
            <td>${student.dailyLink}</td>
            <td>${student.brotherName}</td>
            <td>${student.create_at}</td>
            <td>${student.update_at}</td>
            <td><form action="/user/list/${student.ID}" method="get">
                <input type="submit" value="更新">
            </form> </td>
            <td><form action="/user/deletbyid/${student.ID}" method="post">
                <input type="submit" value="删除">
            </form></td>
        </tr>
    </c:forEach>
</table>

</html>
</body>
</html>
