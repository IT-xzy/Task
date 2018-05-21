<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加</title>

</head>
<body>
<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
<!-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> -->
<form id="itemForm" action="${pageContext.request.contextPath }/stu/addStudent" method="post">
    增加学生：
    <table width="100%" border=1>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="text" name="sex"/></td>
        </tr>
        <tr>
            <td>QQ</td>
            <td><input type="text" name="qq"/></td>
        </tr>
        <tr>
            <td>修真类型</td>
            <td><input type="text" name="whatType"/></td>
        </tr>
        <tr>
            <td>入学时间</td>
            <td><input type="text" name="joinTime"/></td>
        </tr>
        <tr>
            <td>毕业院校</td>
            <td><input type="text" name="school"/></td>
        </tr>
        <tr>
            <td>学号</td>
            <td><input type="text" name="student_id"/></td>
        </tr>
        <tr>
            <td>日报连接</td>
            <td><input type="text" name="link"/></td>
        </tr>
        <tr>
            <td>许愿</td>
            <td><input type="text" name="wishes"/></td>
        </tr>
        <tr>
            <td>师兄</td>
            <td><input type="text" name="tutorBro"/></td>
        </tr>
        <tr>
            <td>从何处了解到修真院</td>
            <td><input type="text" name="knowFrom"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交" />
            </td>
        </tr>
    </table>

</form>
</body>

</html>