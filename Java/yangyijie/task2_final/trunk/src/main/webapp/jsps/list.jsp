<%--
  Created by IntelliJ IDEA.
  User: Yong
  Date: 2017/12/1
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<body>
<a href="${pageContext.request.contextPath}/student/json1">jsontaglib测试</a>
<div >
    <form method="post" action="${pageContext.request.contextPath}/jsps/add.jsp">
        <input type="submit" value="点击新增学生">
    </form>
<table border='1' cellspacing='0'>
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
    <c:forEach items="${studentList}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.QQ}</td>
            <td>${s.major}</td>
            <td>${s.gra_school}</td>
            <td>${s.online_id}</td>
            <td>${s.daily_link}</td>
            <td>${s.bro}</td>
            <td>${s.know_from}</td>
            <td>${s.desire}</td>
            <td>${s.entry_time}</td>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/student/${s.id}">          <%--  <input type="hidden" name="_method" value="PUT">--%>
                    <input type="submit"  value="修改"/>
                </form>
            </td>
                <%--<td><a href="${pageContext.request.contextPath}/student/getdata?id=${s.id}">修改</a></td>--%>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/student/${s.id}">
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="submit"  value="删除"/>
                </form>
            </td>
                <%--<td><a href="${pageContext.request.contextPath }/student/deleteMathod?id=${s.id}" >删除</a></td>--%>
        </tr>
    </c:forEach>
</table>
    </div>
</body>
</html>