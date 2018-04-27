<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/4/13
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>详细信息</title>
</head>
<body>
<div style="width: 1000px;margin: 0px auto;text-align: center">
    <font color="blue" size="4" >详细信息</font><br/>
    <form method="post" action="/task2/person/${personByName.name}">
        <table align="center" border="1" cellspacing="0" >
            <tr>
                <th>姓名</th>
                <td><input type="text" name="name" value="${personByName.name}"></td>
            </tr>
            <tr>
                <th>战斗力</th>
                <td><input type="text" name="fightingCapacity" value="${personByName.fightingCapacity}"></td>
            </tr>
            <tr>
                <th>绝招</th>
                <td><input type="text" name="uniqueSkill" value="${personByName.uniqueSkill}"></td>
            </tr>
        </table>
        <input type="hidden" value="PUT" name="_method">
        <input type="submit" value="确定修改"/></form>
    <form action="/task2/list" method="get">
        <input type="submit" value="返回主页"></form>
    </form>
</div>

</body>
</html>
