<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-5-16
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Json</title>
</head>
<body>

    <json:object>
        <json:property name="supplierId" value="${supplier.supplierId}"/><br/>
        <json:property name="supplierName" value="${supplier.supplierName}"/><br/>
        <json:property name="contactName" value="${supplier.contactName}"/><br/>
        <json:property name="contactMobile" value="${supplier.contactMobile}"/><br/>
        <json:property name="remark" value="${supplier.remark}"/>
        <json:property name="createdDate" value="${supplier.createdDate}"/><br/>
        <json:property name="validFlag" value="${supplier.validFlag}"/><br/>
        <json:property name="updatedDate" value="${supplier.updatedDate}"/><br/>
    </json:object>
<br/>
    <a href="javascript:history.go(-1);">返回</a>
</body>
</html>
