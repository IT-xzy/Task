<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
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
        <td>${student.ID }</td>
        <td>${student.name }</td>
        <td>${student.QQ}</td>
        <td>${student.onlineID}</td>
        <td>${student.time_of_enrollment}</td>
        <td>${student.graduate_institutions}</td>
        <td>${student.report_link}</td>
        <td>${student.hearfrom}</td>
        <td><form action="${pageContext.request.contextPath}/user/student/${student.ID}" method="post">
            <input type="submit" value="更新">
        </form> </td>
        <td><form action="${pageContext.request.contextPath}/user/student/${student.ID}" method="post">
            <input type="hidden" name="_method" value="DELETE">
            <input type="submit" value="删除">
        </form></td>
    </tr>
</table><br>
<br>
<a href="/index.jsp">返回主页</a>
</body>
</html>
