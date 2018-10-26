<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
    <meta content="application/json; charset=UTF-8">
    <title>根据姓名查询返回json</title>
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

    <a href="/student">返回首页</a>
    <div>
        <p>json形式的数据：</p>
    <json:array name="data" var="s" items="${students}">
        <json:object >
            <json:property name="学生Id" value="${s.id}"/>
            <json:property name="姓名" value="${s.name}"/>
            <json:property name="QQ" value="${s.qq}"/>
            <json:property name="修真类型" value="${s.profession}"/>
            <json:property name="入学时间" value="${s.startTime}"/>
            <json:property name="毕业院校" value="${s.graduatedFrom}"/>
            <json:property name="学号" value="${s.onlineId}"/>
            <json:property name="日报链接" value="${s.dailyLink}"/>
            <json:property name="立愿" value="${s.wish}"/>
            <json:property name="辅导师兄" value="${s.counselor}"/>
            <json:property name="从哪里知道修真院" value="${s.way}"/>
            <json:property name="注册时间" value="${s.createAt}"/>
            <json:property name="更新时间" value="${s.updateAt}"/>
        </json:object>
    </json:array>
    </div>

    <div>
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
    </div>
</body>
</html>
