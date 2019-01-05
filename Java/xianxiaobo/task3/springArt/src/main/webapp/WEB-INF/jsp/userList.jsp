<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/11/2
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="code" value="${response.code}"/>
    <json:property name="message" value="${response.message}"/>
    <json:array name="data" var="item" items="${data}">
        <json:object>
            <json:property name="username" value="${item.username}"/>
            <json:property name="password" value="${item.password}"/>
        </json:object>
    </json:array>
</json:object>

