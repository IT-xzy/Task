<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/8/4
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page  isELIgnored = "false" contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>插入数据</title>
</head>
<body>
<div align="center">
    <c:if test="${empty insertStudent}">
        插入失败
    </c:if>
    <c:if test="${!empty insertStudent}">
        <table align='center'  border='1' cellspacing='0'>
            <tr><th align="left" colspan="11">新插入的数据如下:</th></tr>
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>qq</th>
                <th>专业</th>
                <th>毕业院校</th>
                <th>学号</th>
                <th>日报连接</th>
                <th>师兄姓名</th>
                <th>从哪里得知修真院</th>
                <th>创建时间</th>
                <th>更新时间</th>
            </tr>
            <hr>
            <tr>
                <td>${insertStudent.id }</td>
                <td>${insertStudent.name }</td>
                <td>${insertStudent.qq }</td>
                <td>${insertStudent.profession }</td>
                <td>${insertStudent.university}</td>
                <td>${insertStudent.number}</td>
                <td>${insertStudent.daily}</td>
                <td>${insertStudent.senior}</td>
                <td>${insertStudent.from}</td>
                <td>
                    <jsp:useBean id="timestamp1" class="java.util.Date"/>
                    <jsp:setProperty name="timestamp1" property="time" value="${insertStudent.createTime}"/>
                    <fmt:formatDate value="${timestamp1}" pattern="yyyy年MM月dd日 HH:mm:ss"/>
                </td>
                <td>
                    <jsp:useBean id="timestamp2" class="java.util.Date"/>
                    <jsp:setProperty name="timestamp2" property="time" value="${insertStudent.updateTime}"/>
                    <fmt:formatDate value="${timestamp2}" pattern="yyyy年MM月dd日 HH:mm:ss"/>
                </td>
            </tr>
        </table>
    </c:if>
    <h3>json形式显示如下：</h3>
    <json:object>
        <json:property name="name" value="${insertStudent.name}"/>
        <json:property name="qq" value="${insertStudent.qq}"/>
        <json:property name="profession" value="${insertStudent.profession}"/>
        <json:property name="university" value="${insertStudent.university}"/>
        <json:property name="number" value="${insertStudent.number}"/>
        <json:property name="daily" value="${insertStudent.daily}"/>
        <json:property name="senior" value="${insertStudent.senior}"/>
        <json:property name="from" value="${insertStudent.from}"/>
        <json:property name="createTime" value="${insertStudent.createTime}"/>
        <json:property name="updateTime" value="${insertStudent.updateTime}"/>
    </json:object>
    <h3>从后端转过来的json对象</h3>
    ${jsonObject}
</div>
<form action="/u/studentS" method="get">
    <input type="hidden" name="currPage" value="${currPage}">
    <button type="submit">返回</button>
</form>
</body>
</html>
