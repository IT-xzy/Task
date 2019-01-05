<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/10/27
  Time: 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:object>
    <json:property name="code" value="${data.code}"/>
    <json:property name="message" value="${data.message}"/>
    <json:property name="data" value="${data.data}"/>
</json:object>
