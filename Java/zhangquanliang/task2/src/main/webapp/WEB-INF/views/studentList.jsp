<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
    <title>查询学生列表</title>
</head>
<body>
    <script type="text/javascript">
        /*将post method 改变为delete*/
        $(function () {
            $(".delete").click(function () {
                var href = $(this).attr("href");
                $("#formdelete").attr("action", href).submit();
                return false;
            })
        });
    </script>

    <form action="/student/search/">
         <input type="text" name="name" placeholder="请输入姓名">
         <input type="submit" value="根据姓名查询"/>
    </form>
    <form action="/student" method="post">
        <input type="submit" value="添加">
    </form>

    <form id="formdelete" action="${pageContext.request.contextPath}/student/{id}" method="POST">
        <input type="hidden" name="_method" value="DELETE">
    </form>


    <table border="1" cellpadding="0">
    <tr>
        <th>学生Id</th>
        <th>学生姓名</th>
        <th>QQ</th>
        <th>修真类型</th>
        <th>入学时间</th>
        <th>毕业院校</th>
        <th>学号</th>
        <th>日报链接</th>
        <th>立愿</th>
        <th>辅导师兄</th>
        <th>从哪里知道修真院</th>
        <th>注册时间</th>
        <th>更新时间</th>
        <th>操作</th>
    </tr>
    <c:set var="now" value="<%=new java.util.Date()%>"/>
    <c:forEach items="${students}" var="s">
        <jsp:useBean id="createAt" class="java.util.Date" scope="page"/>
        <jsp:setProperty property="time" name="createAt" value="${s.createAt}"/>
        <jsp:useBean id="updateAt" class="java.util.Date" scope="page"/>
        <jsp:setProperty property="time" name="updateAt" value="${s.updateAt}"/>
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.qq}</td>
            <td>${s.profession}</td>
            <td>${s.startTime}</td>
            <td>${s.graduatedFrom}</td>
            <td>${s.onlineId}</td>
            <td>${s.dailyLink}</td>
            <td>${s.wish}</td>
            <td>${s.counselor}</td>
            <td>${s.way}</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${createAt}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${updateAt}"/></td>
            <td>
                <a href="/student/${s.id}">编辑</a>
                <a class="delete" href="/student/${s.id}">删除</a>
            <td>
        </tr>
    </c:forEach>
    </table>

    <div style="text-align:center">
        <a href="?start=0">首 页</a>
        <c:if test="${page.start-page.count>=0}">
            <a href="?start=${page.start-page.count}">上一页</a>
        </c:if>
        <c:if test="${page.start-page.count<0}">
            <a href="javascript:void(0)">上一页</a>
        </c:if>
        <c:if test="${page.start+page.count<=page.last}">
            <a href="?start=${page.start+page.count}">下一页</a>
        </c:if>
        <c:if test="${page.start+page.count>page.last}">
            <a href="javascript:void(0)">下一页</a>
        </c:if>
        <a href="?start=${page.last}">末页</a>
    </div>

</body>
</html>








