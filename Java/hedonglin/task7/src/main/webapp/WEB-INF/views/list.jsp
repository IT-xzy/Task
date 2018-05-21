<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/1/17
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags" prefix="date"%>




<html>

<head>

    <title>学生管理系统</title>

</head>
<body>

    <h1 style="text-align: center">学生管理系统</h1>

    <%--表格--%>
    <div style="text-align: center"></div>
    <table border="12">
        <tr>
            <th>ID</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>姓名</th>
            <th>性别</th>
            <th>QQ</th>
            <th>主修</th>
            <th>入学时间</th>
            <th>来自</th>
            <th>手机号码</th>
            <th>邮箱</th>
            <th>头像</th>
        </tr>
        <%--<c:forEach var="student" items="${studentList}">--%>
            <%--增加按钮--%>
            <form action="${pageContext.request.contextPath}/student/a" method="get">
                <%--</c:forEach>--%>
                <input type="submit" value="增加">
            </form>


            <c:forEach var="student" items="${studentList}">
            <tr>
                <th>${student.id}</th>
                <th><date:date value="${student.createAt}"/></th>
                <th><date:date value="${student.updateAt}"/></th>
                <th>${student.name}</th>
                <th>${student.sex}</th>
                <th>${student.qq}</th>
                <th>${student.major}</th>
                <th>${student.entryTime}</th>
                <th>${student.comeFrom}</th>
                <th>${student.cellphone}</th>
                <th>${student.email}</th>
                <th>${student.headPortrait}</th>

                    <%--修改按钮--%>
                <th>
                    <form action="${pageContext.request.contextPath}/student/u/${student.id}" method="get">
                        <input type="submit" value="修改">
                    </form>
                </th>

                    <%--删除按钮--%>
                <th>
                    <form action="${pageContext.request.contextPath}/student/${student.id}" method="post">
                        <input type="hidden" name="_method" value="DELETE">
                        <input type="submit" value="删除">
                    </form>
                </th>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
