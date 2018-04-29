<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/4/12
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>新增英雄</title>
</head>
<body>
<div style="width: 1000px;margin: 0px auto;text-align: center">
    <font color="blue" size="4" >新增英雄</font><br/>
    <form method="post" action="${pageContext.request.contextPath}/task2/person">
        <table align="center" border="1" cellspacing="0" >
            <tr>
                <th>姓名</th>
                <td><input type="text" name="name" placeholder="请勿重名"></td>
            </tr>
            <tr>
                <th>战斗力</th>
                <td><input type="text" name="fightingCapacity" placeholder="范围0-100" ></td>
            </tr>
            <tr>
                <th>绝招</th>
                <td><input type="text" name="uniqueSkill" ></td>
            </tr>
        </table>

        <input type="submit" value="确定增加"/></form>
    <form action="${pageContext.request.contextPath}/task2/list" method="get">
        <input type="submit" value="返回主页"></form>
    </form>
</div>
<jsp:include page="footer.jsp" >
    <jsp:param  name="year" value="2018" />
</jsp:include>


</body>
</html>
