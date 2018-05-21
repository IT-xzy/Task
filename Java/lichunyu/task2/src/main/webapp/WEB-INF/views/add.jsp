<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-5-13
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加供应商</title>
</head>
<body style="text-align:center">

    <sf:form method="post" modelAttribute="supplier" action="supplier">
        供应商名称:<sf:input path="supplierName"/><sf:errors path="supplierName"/><br/>
        联系人名称:<sf:input path="contactName"/><sf:errors path="contactName"/><br/>
        联系人电话:<sf:input path="contactMobile"/><sf:errors path="contactMobile"/><br/>
        供应商备注:<sf:input path="remark"/><sf:errors path="remark"/><br/>
        可用性标识:<sf:input path="validFlag"/><sf:errors path="validFlag"/><br/>
        <br/>
    <input type="submit" value="确认添加"/>
    </sf:form>
    <a href="javascript:history.go(-1);">返回</a>
    <%-------------增加供应商-------------%>
    <%--<p>--%>
        <%--<label>输入供应商名称：</label> <input type="text"  name ="supplierName" >--%>
        <%--<br/>--%>
        <%--<label>输入联系人名称：</label> <input type="text"  name ="contactName" >--%>
        <%--<br/>--%>
        <%--<label>输入联系人电话：</label> <input type="text"  name ="contactMobile" >--%>
        <%--<br/>--%>
        <%--<label>输入供应商备注：</label> <input type="text"  name ="remark" >--%>
        <%--<br/>--%>
        <%--<label>输入可用性标识：</label> <input type="text"  name ="validFlag" >--%>
    <%--</p>--%>
    <%--<p>--%>
        <%--<button  type="submit" >添加</button>--%>
    <%--</p>--%>
    <%--<form>--%>
<%--<a href="supplierPage">分页显示所有供应商信息</a>--%>
</body>
</html>
