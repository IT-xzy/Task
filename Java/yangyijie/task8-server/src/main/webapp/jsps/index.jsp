<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页</title>
    <style type="text/css">
        td{text-align: center;}
        .td2{text-align: right;}
        .table1{
            border:1px solid #ddd;
        }
        thead{
            background-color:lightblue;
        }
    </style>
</head>
<body>
<font size="7">欢迎:修真院的基佬们</font>
<br>
<a href="${pageContext.request.contextPath}/student/json1">json-taglib测试</a>

<%-- 当前用户：${pageScope.currentUser}<!-- (只能在同一个页面中使用) --> <br>
当前用户：${requestScope.currentUser}-${roleName} 有重定向数据就访问不到<br>
当前用户：${sessionScope.currentUser}-${roleName} 可以使用<br> --%>
<hr>
<br>
<c:if test="${empty requestScope.pagemsg}">
    没有任何用户信息！
</c:if>
<c:if test="${!empty requestScope.pagemsg}">
    <table border="1" cellpadding="10" cellspacing="0" class="table1" width="1300px">
        <thead>
        <tr>
            <td>ID</td>
            <td>学生姓名</td>
            <td>QQ号码</td>
            <td>修真专业</td>
            <td>毕业院校</td>
            <td>在线学号</td>
            <td>日报链接</td>
            <td>辅导师兄</td>
            <td>从哪里知道修真院</td>
            <td>学习愿望</td>
            <td>预计到校时间</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        </thead>
        <c:forEach items="${pagemsg.list}" var="s">
            <tr>
                <th>${s.id}</th>
                <th>${s.name}</th>
                <th>${s.QQ}</th>
                <th>${s.major }</th>
                <th>${s.gra_school }</th>
                <th>${s.online_id}</th>
                <th>${s.daily_link}</th>
                <th>${s.bro}</th>
                <th>${s.know_from}</th>
                <th>${s.desire}</th>
                <th>${s.entry_time}</th>
                <th>
                    <form method="post" action="${pageContext.request.contextPath}/student/${s.id}">          <%--  <input type="hidden" name="_method" value="PUT">--%>

                        <input type="submit"  value="修改"/>
                </form>
                </th>
                <th>
                    <form method="post" action="${pageContext.request.contextPath}/student/${s.id}&${pagemsg.currPage}">
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="submit"  value="删除"/>
                </form>
                </th>
            </tr>
        </c:forEach>
    </table>
</c:if>

<table  border="0" cellspacing="0" cellpadding="0" width="1150px">
    <tr>
        <td>
            <form method="get" action="${pageContext.request.contextPath}/student/name">
                输入姓名进行查询
                <input type="text" name="name" >
                <input type="submit" value="查询" >
            </form>
        </td>
        <td>
            <form method="post" action="${pageContext.request.contextPath}/student/newone">
                <input type="submit" value="点击新增学生" >
            </form>
        </td>
        <td class="td2">
            <span>第${pagemsg.currPage }/ ${pagemsg.totalPage}页</span>&nbsp;&nbsp;
            <span>总记录数：${pagemsg.totalCount }&nbsp;&nbsp;每页显示:${pagemsg.pageSize}</span>&nbsp;&nbsp;
            <span>
       <c:if test="${pagemsg.currPage != 1}">
           <a href="${pageContext.request.contextPath }/student/index?currentPage=1">[首页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/student/index?currentPage=${pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if>
       <c:if test="${pagemsg.currPage != pagemsg.totalPage}">
           <a href="${pageContext.request.contextPath }/student/index?currentPage=${pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/student/index?currentPage=${pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
        跳转
        <td>
            <form method="get" action="${pageContext.request.contextPath}/student/index?">
            <input type="text" name="currentPage" size="3"/>
        </form>
    </td>
    <td>页</td>
    </tr>
</table>
</body>
</html>