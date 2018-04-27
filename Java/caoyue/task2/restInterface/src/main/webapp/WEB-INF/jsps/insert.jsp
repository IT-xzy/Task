<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新增信息</title>
</head>
<body>
添加：
<br><form action="${pageContext.request.contextPath}/user/result" method="post">
    姓名:<br><input type="text" name="name" ><br>
    QQ:<br><input type="text" name="QQ" ><br>
    线上学号:<br><input type="text" name="onlineNumber" ><br>
    毕业时间:<br><input type="text" name="enrollmentTime" ><br>
    职业类型:<br><input type="text" name="professionType"><br>
    日报连接:<br><input type="text" name="dailyLink"><br>
    誓言:<br><input type="text" name="promise"><br>
    师兄名称:<br><input type="text" name="brotherName"><br>
    邮箱:<br><input type="text" name="mail"><br>
    电话:<br><input type="text" name="phone"><br>
    <input type="submit" value="提交">
</form><br>
<a href="/index.jsp">返回</a>
</body>
</html>
