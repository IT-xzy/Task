<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<body>
<h2>查询结果</h2>
    <table border="1">
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>qq</th>
            <th>职业</th>
            <th>入学时间</th>
            <th>学校</th>
            <th>日报链接</th>
            <th>立愿</th>
            <th>师兄</th>
            <th>从何处了解</th>
        </tr>
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.qq}</td>
            <td>${student.ocupation}</td>
            <td>${student.admission_time}</td>
            <td>${student.school}</td>
            <td>${student.daily_link}</td>
            <td>${student.flag}</td>
            <td>${student.brother}</td>
            <td>${student.where_know}</td>
        </tr>
    </table>
<a href="${pageContext.request.contextPath}/index">点击返回首页</a>
</body>
</html>
