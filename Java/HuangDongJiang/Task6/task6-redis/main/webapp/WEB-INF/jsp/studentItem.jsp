<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--<html>--%>
<%--<body>--%>
<%--<h2>查询结果</h2>--%>
    <json:object>
        <%--<json:array name="students" students="${studentList}" var="student">--%>
            <%--<json:object>--%>
        <json:property name="id" value="${student.id}"/>
        <json:property name="name" value="${student.name}"/>
        <json:property name="schllo" value="${student.school}"/>
        <json:property name="qq" value="${student.qq}"/>
        <json:property name="ocupation" value="${student.ocupation}"/>
        <json:property name="admission_time" value="${student.admission_time}"/>
        <json:property name="daily_link" value="${student.daily_link}"/>
        <json:property name="flag" value="${student.flag}"/>
        <json:property name="brother" value="${student.brother}"/>
        <json:property name="where_know" value="${student.where_know}"/>
            <%--</json:object>--%>
        <%--</json:array>--%>
    </json:object>
<%--<a href="${pageContext.request.contextPath}/index">点击返回首页</a>--%>
<%--</body>--%>
<%--</html>--%>
