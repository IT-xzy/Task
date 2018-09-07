<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>通过名字查找</title>
</head>
<body>
<form action="/students" method="get">
    <input type="submit" value="返回主页">
</form>
<br>
<br>
<table border="1" cellspacing="0" cellpadding="0" class="table">
    <thead>
    <tr>
        <td>id</td>
        <td>创建时间</td>
        <td>姓名</td>
        <td>qq</td>
        <td>修真类型</td>
        <td>预计入学时间</td>
        <td>毕业院校</td>
        <td>线上学号</td>
        <td>日报连接</td>
        <td>立愿</td>
        <td>辅导师兄</td>
        <td>城市</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    </thead>
    <c:forEach items="${requestScope.list}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.create_at}</td>
            <td>${student.name}</td>
            <td>${student.qq}</td>
            <td>${student.professional}</td>
            <td>${student.start_time}</td>
            <td>${student.university}</td>
            <td>${student.online_id}</td>
            <td>${student.daily_url}</td>
            <td>${student.oath}</td>
            <td>${student.counselor}</td>
            <td>${student.city}</td>

            <%--<json:object prettyPrint="true">--%>
                <%--<json:property name = "id" value="${student.id}"/>--%>
                <%--<json:property name="create_at" value="${student.create_at}"/>--%>
                <%--<json:property name="name" value="${student.name}"/>--%>
                <%--<json:property name="qq" value="${student.qq}"/>--%>
                <%--<json:property name="professional" value="${student.professional}"/>--%>
                <%--<json:property name="start_time" value="${student.start_time}"/>--%>
                <%--<json:property name="university" value="${student.university}"/>--%>
                <%--<json:property name="online_id" value="${student.online_id}"/>--%>
                <%--<json:property name="daily_url" value="${student.daily_url}"/>--%>
                <%--<json:property name="oath" value="${student.oath}"/>--%>
                <%--<json:property name="counselor" value="${student.counselor}"/>--%>
                <%--<json:property name="city" value="${student.city}"/>--%>
            <%--</json:object>--%>
            <td><form action="/student/${student.id}" method="get">
                <input type="submit" value="编辑">
            </form>
            </td>
            <td><form action="/student/${student.id}" method="post">
                <input type="hidden" value="delete" name="_method">
                <input type="submit" value="删除">
            </form> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>