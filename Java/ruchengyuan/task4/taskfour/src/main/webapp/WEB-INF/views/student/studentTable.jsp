<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/8/2017
  Time: 下午 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/datetag.tld" prefix="date"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<
<table class="style1"
       border="1"
       style="border: thick groove #0066FF; padding: inherit; margin: auto; table-layout: fixed; list-style-type: decimal-leading-zero;">
    <tr>
        <td>
            ID</td>
        <td>
            用户名</td>
        <td>
            密码</td>
        <td>
            职业</td>
        <td>
            班级</td>
        <td>
            名字</td>
        <td>
            qq</td>
        <td>
            立愿</td>
        <td>
            状态</td>
        <td>
            入学时间</td>
        <td>
            操作</td>
    </tr>
    <c:forEach items="${studentTable}" var="studentTable" varStatus="st">
    <tr>
        <td>
            ${studentTable.id}</td>
        <td>
            ${studentTable.user}</td>
        <td>
            ${studentTable.pass}</td>
        <td>
            ${studentTable.profession}</td>
        <td>
        ${studentTable.profession}-${studentTable.classId}班</td>
        <td>
            ${studentTable.name}</td>
        <td>
            ${studentTable.qq}</td>
        <td>
            ${studentTable.wish}</td>

        <td>
            <c:if test="${studentTable.status == 1}">
                在学
            </c:if>
            <c:if test="${studentTable.status == 0}">
                结业
            </c:if>
        </td>
        <td>
            <date:date value ="${studentTable.enrolAt}" /></td>
        <td>
            修改 删除</td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
