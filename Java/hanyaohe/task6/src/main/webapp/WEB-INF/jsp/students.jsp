<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<c:forEach items="${studentList }" var="student">
    <table border="2">
        <tr>
            <td>序号：${student.id}</td>
            <td>姓名：${student.name}</td>
            <td>QQ：${student.qq}</td>
            <td>职业：${student.type}</td>
            <td>入学时间：${student.enrolmenttime}</td>
            <td>毕业院校：${student.graduated}</td>
            <td>学号：${student.number}</td>
            <td>日报链接：${student.daily}</td>
            <td>立愿：${student.ambition}</td>
            <td>辅导师兄：${student.responsible}</td>
            <td>来源：${student.wfrom}</td>
            <td>手机：${student.telipone}</td>
            <td>邮箱：${student.email}</td>
            <td>头像：${student.portrait}</td>
            <td>创建：${student.createAt}</td>
            <td>更新：${student.updateAt}</td>
            <td><form action="${pageContext.request.contextPath}/student/${student.id}" method="post">
                <input type="hidden" name="_method" value="DELETE">
                <input type="submit" value="删除">
            </form></td>
            <td><a href="${pageContext.request.contextPath}/student/u/${student.id}">更新</a></td>
            <td> <a href="${pageContext.request.contextPath}/student/add">新增</a></td>
            <td> <a href="/">首页</a><br/><br/></td></tr></table>
</c:forEach>
</body>
</html>
