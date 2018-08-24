<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1 >查询结果</h1>
<table width="100%" border=1  >
    <tr>
        <th>id</th>
        <th>name</th>
        <th>school</th>
        <th>qq</th>
        <th>ocupation</th>
        <th>admission_time</th>
        <th>daily_link</th>
        <th>flag</th>
        <th>brother</th>
        <th>where_know</th>
    </tr>
</table>
<table width="100%" border=1  >
        <c:forEach items="${studentList}" var="item">
        <tr>
           <td>${item.id}</td>
           <td>${item.name}</td>
           <td>${item.school}</td>
           <td>${item.qq}</td>
           <td>${item.ocupation}</td>
           <td>${item.admission_time}</td>
           <td>${item.daily_link}</td>
           <td>${item.flag}</td>
           <td>${item.brother}</td>
           <td>${item.where_know}</td>
        </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/index">点击返回首页</a>
</body>
</html>
