<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/12
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<body>
<json:object>
    <json:array name="company">
        <c:forEach items="${companies}" var="company">
            <json:object >
                <json:property name="name" value="${company.companyName}"/>
            </json:object>
        </c:forEach>
    </json:array>
</json:object>
</body>
</html>
