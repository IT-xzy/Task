<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="/WEB-INF/com.jin/tld/datetag.tld"  prefix="ltd"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改信息</title>

</head>
<body>
<form id="itemForm" action="${pageContext.request.contextPath }/stu/saveUpdate" method="post">
    <input type="hidden" name="id" value="${student.id}">
    <input type="hidden" name="create_at" value="${student.create_at}">
    <input type="hidden" name="update_at" value="${student.update_at}">
    修改信息：
    <table width="100%" border=1>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${student.name }" /></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="sex" value="${student.sex }" /></td>
        </tr>
        <tr>
            <td>QQ</td>
            <td><input type="text" name="qq" value="${student.qq}"/></td>
        </tr>
        <tr>
            <td>修真类型</td>
            <td><input type="text" name="whatType" value="${student.whatType}"/></td>
        </tr>
        <tr>
            <td>入学时间</td>
            <td><input type="text" name="joinTime" value="${student.joinTime}"/></td>
        </tr>
        <tr>
            <td>毕业院校</td>
            <td><input type="text" name="school" value="${student.school}"/></td>
        </tr>
        <tr>
            <td>学号</td>
            <td><input type="text" name="student_id" value="${student.student_id}"/></td>
        </tr>
        <tr>
            <td>日报连接</td>
            <td><input type="text" name="link" value="${student.link}"/></td>
        </tr>
        <tr>
            <td>许愿</td>
            <td><input type="text" name="wishes" value="${student.wishes}"/></td>
        </tr>
        <tr>
            <td>师兄</td>
            <td><input type="text" name="tutorBro" value="${student.tutorBro}"/></td>
        </tr>
        <tr>
            <td>从何处了解到修真院</td>
            <td><input type="text" name="knowFrom" value="${student.knowFrom}" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交" />
            </td>
        </tr>

    </table>

</form>
</body>

</html>