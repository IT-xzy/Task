<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/8
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<% String appPath = request.getContextPath(); %>--%>

<html>
<head>
    <title>主页</title>
    <style type="text/css">
        td{text-align: center;}
        .td2{text-align: right;}
        .table1{
            border:1px solid #ddd;
            width:900px;
        }
        thead{
            background-color:lightblue;
        }
    </style>
</head>
<body>
<h1>用户信息</h1>
<hr>
<a href="/insert"> 添加用户</a><br>
<a href="/find"> 查询用户</a>
<table border="1" cellpadding="10" cellspacing="0" class="table1">
    <%--border:规定表格边框的宽度;cellpadding:规定单元边沿与其内容之间的空白。
    cellspacing:规定单元格之间的空白;--%>
    <thead>
    <tr>
        <td>编号</td>
        <td>团队成员</td>
        <td>年龄</td>
        <td>体重</td>
        <td>create_at</td>
        <td>update_at</td>
        <td>操作</td>
    </tr>
    </thead>
<c:forEach items="${pagemsg.lists}" var="user" varStatus="st">

        <tr>
            <th>${user.id}</th>
            <th>${user.userName}</th>
            <th>${user.age}</th>
            <th>${user.weight}</th>
            <th>${user.createAt}</th>
            <th>${user.updateAt}</th>
            <td>
                <form action="${path}/category/${user.id}" method="POST">
                    <input type="hidden" name="_method" value="DELETE"/>
                    <input  id="submit" type="submit" value="删除">
                </form>
                    <form action="${path}/change/${user.id}">
                        <input  id="change" type="submit" value="更改">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<%--</c:if>--%>

<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
    <tr>
        <td class="td2">
            <span>第${requestScope.pagemsg.currPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
            <span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
            <span>
       <c:if test="${requestScope.pagemsg.currPage != 1}">
           <a href="${pageContext.request.contextPath }/main?currentPage=1">[首页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/main?currentPage=${requestScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if>

       <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
           <a href="${pageContext.request.contextPath }/main?currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/main?currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
        </td>
    </tr>
</table>
</body>
</html>
