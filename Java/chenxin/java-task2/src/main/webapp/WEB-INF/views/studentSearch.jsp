<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>通过名字查找</title>
</head>
<body>
<hr>
<br>
<br>
<form action="/test/students" method="get">
    <input type="submit" value="返回主页">
</form>
<br>
<br>
    <table border="1" cellspacing="0" cellpadding="0" class="table">
        <thead>
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>qq</td>
            <td>修真类型</td>
            <td>预计入学时间</td>
            <td>毕业院校</td>
            <td>线上学号</td>
            <td>日报连接</td>
            <td>立愿</td>
            <td>辅导师兄</td>
            <td>从何处了解到的修真院</td>
            <td>创建时间</td>
            <td>更新时间</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        </thead>
        <c:forEach items="${requestScope.list}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.qq}</td>
            <td>${student.goal}</td>
            <td>${student.registration_date}</td>
            <td>${student.graduated_from}</td>
            <td>${student.number}</td>
            <td>${student.daily_link}</td>
            <td>${student.pledge}</td>
            <td>${student.senior}</td>
            <td>${student.know_from}</td>
            <td>${student.created_at}</td>
            <td>${student.updated_at}</td>
            <td><form action="/test/student/${student.id}" method="get">
                <input type="submit" value="编辑">
            </form>
            </td>
            <td><form action="/test/student/" method="post">
                <input type="hidden" value="delete" name="_method">
                <input type="submit" value="删除">
            </form> </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>