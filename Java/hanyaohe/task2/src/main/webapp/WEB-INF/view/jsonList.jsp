<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<json:object >
    <json:array name="学员信息" var="student" items="${students}">
        <json:object>
            <json:property name="id" value="${student.id}"/>
            <json:property name="姓名" value="${student.name}"/>
            <json:property name="QQ" value="${student.qq}"/>
            <json:property name="major" value="${student.major}"/>
        </json:object>
    </json:array>
</json:object>





































