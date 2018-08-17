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
    <%--<json:object>
        &lt;%&ndash;列表部分&ndash;%&gt;
        <json:array name="items" items="${studentList}" var="item">
            <json:object>
                <json:property name="id" value="${item.id}"/>
                <json:property name="name" value="${item.name}"/>
                <json:property name="schllo" value="${item.school}"/>
                <json:property name="qq" value="${item.qq}"/>
                <json:property name="ocupation" value="${item.ocupation}"/>
                <json:property name="admission_time" value="${item.admission_time}"/>
                <json:property name="daily_link" value="${item.daily_link}"/>
                <json:property name="flag" value="${item.flag}"/>
                <json:property name="brother" value="${item.brother}"/>
                <json:property name="where_know" value="${item.where_know}"/>
            </json:object>
        </json:array>
    </json:object>--%>
</body>
</html>
