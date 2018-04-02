<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>学员信息</title>
</head>
<body>
<div style="width:1200px;margin:0px auto;text-align:center">
    <font color="blue" size="5" >学员名单</font><br/>
    <form method="GET" action="/u/task2/student">
    <input type="submit" value="新增学员信息"/></form>
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <th>学员姓名</th>
            <th>修真类型</th>
            <th>在线学号</th>
            <th>查看详情</th>
            <th>点击删除</th>
        </tr>
        <c:forEach items="${requestScope.pagemsg.lists}" var="student">
            <tr>
                <th>${student.name}</th>
                <th>${student.type}</th>
                <th>${student.num}</th>
                <th>
                    <form action="/u/task2/student/${student.id}" method="GET">
                        <input type="submit" value="查看详情"></form>
                </th>
                <th>
                    <form action="/u/task2/student/${student.id}" method="POST">
                        <input type="hidden" value="DELETE" name="_method">
                        <input type="submit" value="点击删除">
                    </form>
                </th>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="5" class="td2">
                <span>第${requestScope.pagemsg.currPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
                <span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
                <span>
       <c:if test="${requestScope.pagemsg.currPage != 1}">
           <a href="${pageContext.request.contextPath }/u/task2/student/list?currentPage=1">[首页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/u/task2/student/list?currentPage=${requestScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if>

       <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
           <a href="${pageContext.request.contextPath }/u/task2/student/list?currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/u/task2/student/list?currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
            </td>
        </tr>

    </table>
</div>
<div style="width:500px;margin:0px auto;text-align:center">
    <tr>
        <td>
            <form method="GET" action="/u/task2/student/name">
                <input type="text" name="name" value=""/>
                <input type="submit" value="输入姓名智能查询"/></form>
        </td>
        <td>
            <form method="GET" action="/u/task2/student/num">
                <input type="text" name="num" value=""/>
                <input type="submit" value="输入学号精确查询"/></form>
        </td>
        <td>
            <a href="/task4/home">返回技能树</a>
        </td>
    </tr>
</div>
</body>
</html>
