<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/11
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<body>
<json:object>
    <json:array name="people">
        <c:forEach items="${peo}" var="peo">
            <json:object >
                <json:property name="name" value="${peo.name}"/>
                <json:property name="info" value="${peo.info}"/>
                <json:property name="creatTime" value="${peo.creatTime}"/>
            </json:object>
        </c:forEach>
    </json:array>
</json:object>
</body>
</html>
