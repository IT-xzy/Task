<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>学号查询结果</title>
</head>
<body>
    <div style="width:1800px;margin:0px auto;text-align:center">
        <font color="blue" size="5" >学号查找结果</font><br/>
        <table align='center' border='1' cellspacing='0'>
            <tr>
                <td>姓名</td>
                <td>${studentForNumber.name}</td>
            </tr>
            <tr>
                <td>QQ</td>
                <td>${studentForNumber.QQ}</td>
            </tr>
            <tr>
                <td>修真类型</td>
                <td>${studentForNumber.type}</td>
            </tr>
            <tr>
                <td>预计入学时间</td>
                <td>${studentForNumber.admissionTime}</td>
            </tr>
            <tr>
                <td>毕业院校</td>
                <td>${studentForNumber.school}</td>
            </tr>
            <tr>
                <td>在线学号</td>
                <td>${studentForNumber.num}</td>
            </tr>
            <tr>
                <td>日报链接</td>
                <td>${studentForNumber.daily}</td>
            </tr>
            <tr>
                <td>宣言</td>
                <td>${studentForNumber.declaration}</td>
            </tr>
            <tr>
                <td>辅导师兄</td>
                <td>${studentForNumber.elder}</td>
            </tr>
            <tr>
                <td>从何处了解</td>
                <td>${studentForNumber.knewFrom}</td>
            </tr>
        </table>
        <form action="/task2/student/list" method="GET">
            <input type="submit" value="返回主页"></form>
    </div>

</body>
</html>