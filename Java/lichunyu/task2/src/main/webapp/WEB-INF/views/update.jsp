<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-5-13
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑供应商</title>
</head>
<body style="text-align:center">
<sf:form method="post" modelAttribute="supplier" action="supplier">
    <input type="hidden" name="_method" value="put">
    供应商编号:<sf:input path="supplierId"/><sf:errors path="supplierId"/><br/>
    供应商名称:<sf:input path="supplierName"/><sf:errors path="supplierName"/><br/>
    联系人名称:<sf:input path="contactName"/><sf:errors path="contactName"/><br/>
    联系人电话:<sf:input path="contactMobile"/><sf:errors path="contactMobile"/><br/>
    供应商备注:<sf:input path="remark"/><sf:errors path="remark"/><br/>
    <br/>
    <input type="submit" value="确认编辑"/>
</sf:form>
<a href="javascript:history.go(-1);">返回</a>
</body>
</html>
