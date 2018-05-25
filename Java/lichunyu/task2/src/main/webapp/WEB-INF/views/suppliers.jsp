
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-5-11
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <%--分页显示所有，有分页和跳转--%>
    <title>分页显示所有数据</title>
</head>
<body>
数据列表：
<table width="100%" border=1>
    <%--表格样式--%>
    <style type="text/css">
        #tbList {
            border:1px solid #0094ff;
            width:600px;
            margin:10px auto; /*上下10px；左右水平居中*/
            border-collapse:collapse;/*设置为收缩边框*/
        }
        #tbList tr,th, td {
            border:1px solid #0094ff;
            padding:10px;/*将内容与单元格填充开*/
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

    <c:forEach items="${list}" var="data">
        <tr>
            <td>${data.supplierId}</td>
            <td>${data.supplierName}</td>
            <td>${data.contactName }</td>
            <td>${data.contactMobile }</td>
            <td>${data.remark}</td>
            <td>${data.createdDate }</td>
            <td>${data.validFlag}</td>
            <td>${data.updatedDate }</td>
            <td>
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
    </c:forEach>
</table>

<div style="text-align:center">
    当前${pageBean.start/10+1}页
    共有${pageBean.total}行
    <br/>
    <a href="?start=0">首  页</a>
    <%--如果当前页开始行减去每页总行小于0，说明为第一页，隐藏上一页按钮--%>
    <c:if test="${pageBean.start-pageBean.count<0}">
        <a href="javascript:void(0)"></a>
    </c:if>
    <c:if test="${pageBean.start-pageBean.count>=0}">
        <a href="?start=${pageBean.start-pageBean.count}">上一页</a>
    </c:if>
    <%--如果当前页开始行加上每页总行大于最后行数，说明为最后一页，隐藏下一页按钮--%>
    <c:if test="${pageBean.start+pageBean.count<=pageBean.last}">
        <a href="?start=${pageBean.start+pageBean.count}">下一页</a>
    </c:if>
    <c:if test="${pageBean.start+pageBean.count>pageBean.last}">
        <a href="javascript:void(0)"></a>
    </c:if>

    <a href="?start=${pageBean.last}">末  页</a>
    <br/>
    <a href="update">修改供应商</a>
    <a href="add">添加供应商</a>

    <form action="suppliers" >
        跳转到<<input  type="text" name="start">+1行
        <button type="submit">确认</button>
    </form>
    <a href="javascript:history.go(-1);">返回</a>
</div>
</body>
</html>
