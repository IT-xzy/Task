<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-5-12
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <%--实现id查询功能--%>
    <title>ID查询</title>
</head>
<body>
<a href="javascript:history.go(-1);">返回查询页</a>
数据列表：
<table width="100%" border=1>
    <%--表格样式--%>
    <style type="text/css">
        #tbList {
            border:1px solid #0094ff;
            width:800px;
            margin:5px auto; /*上下10px；左右水平居中*/
            border-collapse:collapse;/*设置为收缩边框*/
        }
        #tbList tr,th, td {
            border:1px solid #0094ff;
            padding:5px;/*将内容与单元格填充开*/
        }
    </style>
    <tr>
        <th>ID</th>
        <th>supplierName</th>
        <th>contactName</th>
        <th>contactMobile</th>
        <th>remark</th>
        <th>createdDate</th>
        <th>validFlag</th>
        <th>updatedDate</th>
        <th>Method</th>
    </tr>

        <tr>
            <td>${supplier.supplierId}</td>
            <td>${supplier.supplierName}</td>
            <td>${supplier.contactName }</td>
            <td>${supplier.contactMobile }</td>
            <td>${supplier.remark}</td>
            <td>${supplier.createdDate }</td>
            <td>${supplier.validFlag}</td>
            <td>${supplier.updatedDate }</td>
            <td>
                <a href="/update">修改</a>
                <form action="/supplier/${data.supplierId}"  method="post">
                    <input type="hidden" value="delete" name="_method">
                    <%--<input type="submit" value="删除">--%>
                    <button onClick="return fun()" >删除</button>
                    <script>
                        function fun(){
                            alert("删除成功")
                        }
                    </script>
                </form>
            </td>
        </tr>
    </>
</table>
<br/>
</body>
</html>
