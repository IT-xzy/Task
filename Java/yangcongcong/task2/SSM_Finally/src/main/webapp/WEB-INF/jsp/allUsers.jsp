<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/4/3
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>User Info</title>
</head>
<body>
    <%--所有用户--%>
    <div style="text-align: center">
        <table align='center' border='1' cellspacing='0'>
            <tr>
                <td>id</td>
                <td>name</td>
                <td>number</td>
                <td>qq</td>
                <td>type</td>
                <td>university</td>
                <td>time</td>
                <td>daily_link</td>
                <td>pledge</td>
                <td>senior</td>
                <td>locality</td>
                <td>create_at</td>
                <td>update_at</td>
                <td colspan="2">操作</td>
            </tr>
            <c:forEach var="u" items="${pageInfo.list}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                    <td>${u.number}</td>
                    <td>${u.qq}</td>
                    <td>${u.type}</td>
                    <td>${u.university}</td>
                    <td>${u.time}</td>
                    <td>${u.daily_link}</td>
                    <td>${u.pledge}</td>
                    <td>${u.senior}</td>
                    <td>${u.locality}</td>
                    <td>${u.create_at}</td>
                    <td>${u.update_at}</td>
                    <%--修改&删除--%>
                    <td>
                        <form action="${path}/users/${u.id}" method="get">
                            <input type="submit" value="修改"/>
                        </form>
                    </td>
                    <td>
                        <form action="${path}/users/${u.id}" method="post">
                            <input type="hidden" name="_method" value="delete"/>
                            <input type="submit" value="删除"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <%--分页--%>
    <div style="text-align: center">
        <a href="${path}/users?pn=1">首页</a>
        <c:if test="${pageInfo.pageNum>1}"><a href="${path}/users?pn=${pageInfo.pageNum-1}">上一页</a> </c:if>
        <c:if test="${pageInfo.pageNum<=1}"><a href="${path}/users?pn=#">上一页</a></c:if>
        <c:if test="${pageInfo.pageNum<pageInfo.pages}"><a href="${path}/users?pn=${pageInfo.pageNum+1}">下一页</a> </c:if>
        <c:if test="${pageInfo.pageNum>=pageInfo.pages}"><a href="#">下一页</a> </c:if>
        <a href="${path}/users?pn=${pageInfo.pages}">末页</a><br><br><br>
    </div>
    <%--新增--%>
    <div style="text-align: center">
        <form action="${path}/user" method="get">
            <input type="submit" value="新增"/>
        </form>
    </div>
</body>
</html>
