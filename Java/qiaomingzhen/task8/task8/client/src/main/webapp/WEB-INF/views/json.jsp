<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/4
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@taglib uri="/tags" prefix="date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<json:object>
    <json:property name="code" value="${result.code}"/>
    <json:property name="message" value="${result.msg}"/>
</json:object>