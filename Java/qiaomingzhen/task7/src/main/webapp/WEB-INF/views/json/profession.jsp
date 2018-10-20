<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/12
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<body>
<json:object>
    <json:array name="profession">
        <c:forEach items="${list}" var="prof">
            <json:object >
                <json:property name="name" value="${prof.profName}"/>
                <json:property name="Sill" value="${prof.profSill}"/>
                <json:property name="Level" value="${prof.profLevel}"/>
                <json:property name="Cycle" value="${prof.profCycle}"/>
                <json:property name="Need" value="${prof.profNeed}"/>
                <json:property name="Time1" value="${prof.profTime1}"/>
                <json:property name="Time3" value="${prof.profTime3}"/>
                <json:property name="Time5" value="${prof.profTime5}"/>
                <json:property name="sum" value="${prof.sum}"/>
                <json:property name="Language" value="${prof.profLanguage}"/>
            </json:object>
        </c:forEach>
    </json:array>
</json:object>
</body>
</html>
