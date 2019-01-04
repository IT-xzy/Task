<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/11/2
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%--返回json,jsp页面头部的contentType一定要指定为application/json;charset=UTF-8，
这样才会返回json。因为如果不指定的话jsp默认contentType="text/html;charset=utf-8" ，
这样返回的并不是真正的json串 ,只是一般的html/text文本装的json形式的字符串而已。--%>
<%@ page contentType="application/json;charset=UTF-8" language="java" isErrorPage="true" isELIgnored="false"
   import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<json:object escapeXml="false">
    <json:property name="code" value="${code}"> </json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:array name="data" items="${student4List}" var="student4">
        <json:object>
            <json:property name ="name" value="${student4.name}"/>
            <json:property name ="img" value="${student4.img}"/>
            <json:property name ="resume" value="${student4.resume}"/>
            <json:property name ="graduateAt" value="${student4.graduateAt}"/>
        </json:object>
    </json:array>
</json:object>

