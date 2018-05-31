<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>输入新的学生信息</title>
</head>
<body>
<div style="width:1800px;margin:0px auto;text-align:center">
    <font color="blue" size="5" >请编辑你的信息</font><br/>
    <form method="POST" action="/u/task2/student"><!--指向的是路径名称-->
        <table align='center' border='1' cellspacing='0'>
            <tr>
                <td>姓名</td>
                <td>QQ</td>
                <td>修真类型</td>
                <td>预计入学时间</td>
                <td>毕业院校</td>
                <td>在线学号</td>
                <td>日报链接</td>
                <td>宣言</td>
                <td>辅导师兄</td>
                <td>从何处了解</td>
            </tr>

            <tr>
                <td><input type="text" name="name" value=""/></td>
                <td><input type="text" name="qq" value=""/></td>
                <td><input type="text" name="type" value=""/></td>
                <td><input type="text" name="admissionTime" value=""/></td>
                <td><input type="text" name="school" value=""/></td>
                <td><input type="text" name="num" value=""/></td>
                <td><input type="text" name="daily" value=""/></td>
                <td><input type="text" name="declaration" value=""/></td>
                <td><input type="text" name="elder" value=""/></td>
                <td><input type="text" name="knewFrom" value=""/></td>
            </tr>

            <tr>
                <td colspan="10" align="center"><input type="submit" value="提交"/>
                </td>
            </tr>
        </table>
    </form>
    <form action="/u/task2/student/list" method="GET">
        <input type="submit" value="返回主页"></form>
</div>
</body>

</html>
