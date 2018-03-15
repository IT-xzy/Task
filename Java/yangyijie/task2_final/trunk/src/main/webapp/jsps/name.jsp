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
<%-- 当前用户：${pageScope.currentUser}<!-- (只能在同一个页面中使用) --> <br>
当前用户：${requestScope.currentUser}-${roleName} 有重定向数据就访问不到<br>
当前用户：${sessionScope.currentUser}-${roleName} 可以使用<br> --%>
<hr>
<br>
<c:if test="${empty requestScope.nameList}">
   <font size="7" >没有任何用户信息！</font>
</c:if>
<c:if test="${!empty requestScope.nameList}">
    <table border="1" cellpadding="10" cellspacing="0" class="table1">
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
        <c:forEach items="${requestScope.nameList}" var="s">
            <tr>
                <th>${s.id }</th>
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
                    <form method="post" action="${pageContext.request.contextPath}/name/${s.id}">
                        <input type="hidden" name="_method" value="DELETE">
                        <input type="submit"  value="删除"/>
                    </form>
                </th>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>