<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/28
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags" prefix="date"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<date:date value="${rs.time_of_enrollment}"/><br>
<%--通过<jsp:useBean />  导入java.util.Date类--%>
<jsp:useBean id="datevalue" class="java.util.Date"/>
<%--2.通过<jsp:setProperty />为Date实例设置long型 time属性值--%>
<jsp:setProperty name="datevalue" property="time" value="${rs.time_of_enrollment}"/>
<%--通过<fmt:formatDate  />格式化Date实例--%>
<fmt:formatDate value="${datevalue}" pattern="yyyy-MM-dd HH:mm:ss"/>
<center>查询结果</center>
<table width="60%" border="1" cellpadding="2" cellspacing="0" align="center">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>QQ</th>
        <th>onlineID</th>
        <th>time_of_enrollment</th>
        <th>graduate_institutions</th>
        <th>report_link</th>
        <th>hearfrom</th>
        <th> </th>
        <th> </th>
    </tr>
    <tr>
        <td>${rs.ID}</td>
        <td>${rs.name }</td>
        <td>${rs.QQ}</td>
        <td>${rs.onlineID}</td>
        <td>${rs.time_of_enrollment}</td>
        <td>${rs.graduate_institutions}</td>
        <td>${rs.report_link}</td>
        <td>${rs.hearfrom}</td>

        <td><form action="${pageContext.request.contextPath}/student/${student.ID}" method="post">
            <input type="submit" value="更新">
        </form> </td>
        <td><form action="${pageContext.request.contextPath}/student/${student.ID}" method="post">
            <input type="hidden" name="_method" value="DELETE">
            <input type="submit" value="删除">
        </form></td>
    </tr>
</table><br>
<br>
<a href="/index.jsp">返回主页</a>
</body>
</html>
