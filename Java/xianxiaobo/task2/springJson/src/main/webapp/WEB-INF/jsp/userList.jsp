<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/10/25
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:array name="data" var="item" items="${data}">
    <json:object>
        <json:property name="id" value="${item.id}"/>
        <json:property name="name" value="${item.name}"/>
        <json:property name="sex" value="${item.sex}"/>
        <json:property name="phone" value="${item.phone}"/>
    </json:object>
</json:array>

