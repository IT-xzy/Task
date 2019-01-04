<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/10/25
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:object>
    <json:property name="id" value="${data.id}"/>
    <json:property name="name" value="${data.name}"/>
    <json:property name="sex" value="${data.sex}"/>
    <json:property name="phone" value="${data.phone}"/>
</json:object>

