<%--
  Created by IntelliJ IDEA.
  User: liujunpeng
  Date: 2018/5/23
  Time: 上午11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
    <title>用户列表</title>

</head>

<body>
<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <h1>成都分院</h1>
        </div>
    </div>
    <!-- 按钮 -->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <a class="btn btn-primary" href="${path}/demo/toAddUser">新增</a>
        </div>
    </div>
</div>
<table border="1">
    <tbody>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>QQ</th>
        <th>入学时间</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
    </tr>
    <c:if test="${!empty userList }">
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name }</td>
                <td>${user.QQ}</td>
                <td>${user.rxtime}</td>
                <td>${user.create_at}</td>
                <td>${user.update_at}</td>
                <td>
                    <form action="<%=basePath%>demo/delUser/${user.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="删除">
                    </form>

                    <%--<form action="<%=basePath%>demo/getUser/${user.id}" method="post">--%>
                        <%--<input type="hidden" name="_method" value="GET">--%>
                        <%--<input type="submit" value="编辑">--%>
                    <%--</form>--%>
                    <a href="<%=basePath%>demo/getUser?id=${user.id}">编辑</a>
                    <%--<a href="<%=basePath%>demo/delUser?id=${user.id}">删除</a>--%>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</tbody>
</table>

<div class="pagging">
    <div class="left">共${userNum}条记录</div>
    <div class="right">
        <c:if test="${currentPage == 1}">
            <span class="disabled"><< 前一页</span>
        </c:if>
        <c:if test="${currentPage != 1}">
            <a href="${pageContext.request.contextPath}/demo/getAllUser?page=${currentPage-1}"><< 前一页</a>
        </c:if>
        <c:if test="${currentPage == 1}">
            <span class="current">1</span>
        </c:if>
        <c:if test="${currentPage != 1}">
            <a href="${pageContext.request.contextPath}/demo/getAllUser?page=1">1</a>
        </c:if>
        <%
            int pageTimes = (Integer) session.getAttribute("pageTimes");
            for (int i = 1; i < pageTimes; i++) {
                request.setAttribute("page", i + 1);
        %>
        <c:if test="${currentPage == page}">
            <span class="current"><%=i + 1%></span>
        </c:if>
        <c:if test="${currentPage != page}">
            <a href="${pageContext.request.contextPath}/demo/getAllUser?page=<%=i+1%>"><%=i + 1%>
            </a>
        </c:if>
        <%} %>

        <c:if test="${currentPage == pageTimes}">
            <span class="disabled">后一页 >></span>
        </c:if>
        <c:if test="${currentPage != pageTimes}">
            <a href="${pageContext.request.contextPath}/demo/getAllUser?page=${currentPage+1}">后一页 >></a>
        </c:if>
    </div>
</div>
<br/>


</body>

</html>