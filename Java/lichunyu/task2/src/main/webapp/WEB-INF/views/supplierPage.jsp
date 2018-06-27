
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
<a href="javascript:history.go(-1);">返回</a>
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
    当前${page.currentPage}页

        <a href="?currentPage=1">首  页</a>
    <%--上一页--%>
    <c:if test="${page.currentPage<=1}">
        <a href="javascript:void(0)"></a>
    </c:if>
    <c:if test="${page.currentPage>1}">
        <a href="?currentPage=${page.currentPage-1}">上一页</a>
    </c:if >
    <%--下一页--%>
    <c:if test="${page.currentPage<page.totalPage}">
        <a href="?currentPage=${page.currentPage+1}">下一页</a>
    </c:if>
    <c:if test="${page.currentPage>=page.totalPage}">
        <a href="javascript:void(0)"></a>
    </c:if>
    <a href="?currentPage=${page.totalPage}">末  页</a>

    共${page.totalPage}页
    <br/>
    <a href="update">修改供应商</a>
    <a href="add">添加供应商</a>

    <form action="/supplierPage" >
        跳转到<input  type="text" name="currentPage">页
        <button type="submit">确认</button>
    </form>
    <%--查询入口--%>
    <form action="supplierList" >
        <p>
            <label>根据Name模糊查询：</label> <input type="text"  name ="supplierName" >
            <button  type="submit">查询</button>
        </p>
    </form>
    <form action="supplier" >
        <p>
            <label>根据ID精确查询列表：</label> <input type="text"  name ="supplierId" >
            <button type="submit" >查询</button>
        </p>
    </form>
    <form action="/json" >
        <p>
            <label>根据ID查询返回Json：</label> <input type="text"  name ="supplierId" >
            <button type="submit" >查询</button>
        </p>
    </form>
</div>
</body>
</html>

