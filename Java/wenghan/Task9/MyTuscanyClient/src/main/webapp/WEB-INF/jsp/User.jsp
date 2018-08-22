<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/4
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>测试页面</title>
</head>
<body>
<h1>测试负载均衡：无缓存CRUD</h1>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>qq</td>
        <td>查询</td>
        <td>查询JSP</td>
        <td>查询JSON</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${list.list}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.qq}</td>
            <td>
                <form method="get" action="/User/${c.id}">
                    <input type="hidden" name="id" value="${c.id}">
                    <input type="hidden" name="name" value="${c.name}">
                    <input type="submit" value="查询">
                </form>
            </td>
            <td>
                <form method="get" action="/JSP/${c.id}">
                    <input type="hidden" name="id" value="${c.id}">
                    <input type="hidden" name="name" value="${c.name}">
                    <input type="submit" value="查询JSP">
                </form>
            </td>
            <td>
                <form method="get" action="/JSON/${c.id}">
                    <input type="hidden" name="id" value="${c.id}">
                    <input type="hidden" name="name" value="${c.name}">
                    <input type="submit" value="查询JSON">
                </form>
            </td>
            <td>
                <form method="get" action="/User/${c.id}">
                    <input type="hidden" name="id" value="${c.id}">
                    <input type="submit" value="编辑">
                </form>
            </td>
            <td>
                <form method="post" action="/User/${c.id}">
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="hidden" name="id" value="${c.id}">
                    <input type="submit" value="删除">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<div style="text-align:center">
    <p>页面总数：${list.totalPage}
        学员总数：${list.totalRecord}
        当前页数：${list.pageNum}</p>
    <%--首页--%>
    <a href="${pageContext.request.contextPath}/UserList?pageNum=1">首页</a>
    <%--上一页--%>
    <c:if test="${list.pageNum-1>1}">
        <a href="${pageContext.request.contextPath}/UserList?pageNum=${list.pageNum-1}">上一页</a>
    </c:if>
    <%--循环遍历当前页的前后5页--%>
    <c:forEach begin="${list.start}" end="${list.end}" step="1" var="i">
        <%--当前页不需要链接跳转--%>
        <c:if test="${list.pageNum == i}">
            ${i}
        </c:if>
        <c:if test="${list.pageNum != i}">
            <a href="${list.contextPath}/UserList?pageNum=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%--下一页--%>
    <c:if test="${list.pageNum+1<list.totalPage}">
        <a href="${pageContext.request.contextPath}/UserList?pageNum=${list.pageNum+1}">下一页</a>
    </c:if>
    <%--末页--%>
    <a href="${pageContext.request.contextPath}/UserList?pageNum=${list.totalPage}">末页</a>
</div>
<div style="text-align:center">
    <p>添加用户</p>
    <form action="User" method="post">
        <input type="text" name="name" >
        <input type="text" name="qq" >
        <input type="submit" value="增加">
    </form>
</div>
</body>
</html>
