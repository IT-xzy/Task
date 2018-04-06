<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示信息进行修改</title>
</head>
<body>
添加：
<br><form action="${pageContext.request.contextPath}/user/student" method="post" align="center">
    姓名:<br><input type="text" name="name" >*<br>
    QQ:<br><input type="text" name="QQ" >*<br>
    onlineID:<br><input type="text" name="onlineID" >*<br>
    time_of_enrollment:<br><input type="date" name="time_of_enrollment" >*<br>
    graduate_institutions:<br><input type="text" name="graduate_institutions"><br>
    report_link:<br><input type="text" name="report_link"><br>
    swear:<br><input type="text" name="swear"><br>
    hearfrom:<br><input type="text" name="hearfrom"><br>
    <input type="submit" value="提交">带*为必填项
</form><br>
<a href="/index.jsp">返回主页</a>
</body>
</html>
