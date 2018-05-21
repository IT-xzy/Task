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
页面一  ${check}
<c:forEach items="${studentList }" var="obj">
    <table border="2">
        <tr>
            <td>序号：${obj.id}&nbsp;&nbsp;</td>
            <td>姓名：${obj.name}&nbsp;</td>
            <td>性别：${obj.sex}&nbsp;</td>
            <td>
                <form action="/student/${obj.id}" method="POST">
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="submit" value="删除">
                </form>
            </td>
            <td><a href="/student/modify">更新</a>&nbsp;</td>
            <td><a href="/student/register">新增</a>&nbsp;</td>
            <td><a href="/">首页</a><br/><br/></td>
            <td><a href="/studentId/${obj.id}">单个学员</a></td>
        </tr>
    </table>
</c:forEach>
</body>
</html>