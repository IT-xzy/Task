<%--<%@ page import="java.util.Date" %>--%>
<%--<%@ page import="java.text.SimpleDateFormat" %>--%>

<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/8/2017
  Time: 上午 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix ="json" uri ="http://www.atg.com/taglibs/json"%>
<%@ taglib uri="/WEB-INF/tld/datetag.tld" prefix="date"%>
<%--<%!String Date;Long time; %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <json:object>
        <json:array name="所有学员信息" items="${students}" var="students"  >
            <json:object>
                <json:property name="学号" value="${students.id}" />
                <json:property name="姓名" value="${students.name}" />
                <json:property name="qq" value="${students.qq}" />
                <json:property name="职业" value="${students.profession}" />
                <json:property name="是否在学" value="${students.status}"/>
                <json:property name="用户名" value="${students.user}" />
                <json:property name="誓言" value="${students.wish}" />
                <%--<date:date  name="入学时间" value ="${students.enrolAt}"  />--%>
                <json:property name="入学时间" value="${students.enrolAt}" />
            </json:object>
        </json:array>
    </json:object>
</body>
</html>
