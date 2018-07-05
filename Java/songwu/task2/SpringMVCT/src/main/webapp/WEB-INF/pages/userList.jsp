<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<％@ taglib prefix =“json”uri =“http://www.atg.com/taglibs/json”％>--%>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/6/11
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学员表</title>
</head>
<body>
<h>学员信息表如下：</h>
<form action="${pageContext.request.contextPath}/mvc/addUser" method="post">
    <br> 新增:
    姓名：<input type="text" name="name" size="5">
    QQ：<input type="text" name="qq"  size="5">
    修真类型：<input type="text" name="type"  size="5">
    <input type="hidden" name="pageCount" value="${page.count}">
    <input type="hidden" name="pageId" value="${page.countPage}">
    <input type="submit" value="提交">
</form>
<form action="${pageContext.request.contextPath}/mvc/getUserAll" method="get">
    <br>综合查询：<br>
    编号： <input type="text" name="id" size="5">
    姓名：<input type="text" name="name" size="5">
    QQ：<input type="text" name="qq" size="5">
    修真类型：<input type="text" name="type" size="5">
    <input type="submit" value="查询">


</form>
<table frame="box" rules="all">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>QQ</td>
        <td>修真类型</td>
        <td align="center">创建时间</td>
        <td align="center">修改时间</td>
        <td>删除</td>
        <td>修改</td>
    </tr>

    <c:forEach items="${list}" var="u" begin="0" end="${fn:length(list)}">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.qq}</td>
            <td>${u.type}</td>
            <%--格式化标签时间转化--%>
            <td>
                <span style="font-size:18px;">
                    <jsp:useBean id="createDate" class="java.util.Date"></jsp:useBean>
                    <jsp:setProperty name="createDate" property="time" value="${u.createAt}"></jsp:setProperty>
                    <fmt:formatDate value="${createDate}" pattern="yyy-MM-dd HH:mm:ss"></fmt:formatDate>
                </span>
            </td>
            <td>
                <span style="font-size:18px;">
                    <jsp:useBean id="updateDate" class="java.util.Date"></jsp:useBean>
                    <jsp:setProperty name="updateDate" property="time" value="${u.updateAt}"></jsp:setProperty>
                    <fmt:formatDate value="${updateDate}" pattern="yyy-MM-dd HH:mm:ss"></fmt:formatDate>
                </span>
            </td>



            <form action="${pageContext.request.contextPath}/mvc/delUser" method="post">
                <input type="hidden" name="id" value="${u.id}">
                <input type="hidden" name="pageId" value="${page.currentPage}">
                <input type="hidden" name="_method" value="delete">
                <td><input type="submit" value="删除"></td>
            </form>

            <form action="${pageContext.request.contextPath}/mvc/edit">
                <input type="hidden" name="id" value="${u.id}">
                <input type="hidden" name="pageId" value="${page.currentPage}">
                <td><input type="submit" value="修改"></td>
            </form>
        </tr>

    </c:forEach>

</table>
<table>
    <tr items="${page}">
        <form action="${pageContext.request.contextPath}/mvc/page">
            <input type="hidden" name="pageId" value="1">
            <input type="submit" value="首页">
        </form>
        <form action="${pageContext.request.contextPath}/mvc/page">
            <input type="hidden" name="pageId" value="${page.prePage}">
            <input type="submit" value="上一页">
        </form>
        <form action="${pageContext.request.contextPath}/mvc/page">
            <input type="hidden" name="pageId" value="${page.nextPage}">
            <input type="submit" value="下一页">
        </form>
        <form action="${pageContext.request.contextPath}/mvc/page">
            <input type="hidden" name="pageId" value="${page.countPage}">
            <input type="submit" value="尾页">

        </form>


        <form action="${pageContext.request.contextPath}/mvc/page">
            <input type="submit" value="跳转到">
            <input type="text" name="pageId" size="2">页
        </form>
</table>

<table>
    共${page.countPage}页;
    当前显示第${page.currentPage}页;
    每页显示${page.pageSize}行;
    总数据<${page.count}>条
    </tr>

</table>
</body>
</html>
