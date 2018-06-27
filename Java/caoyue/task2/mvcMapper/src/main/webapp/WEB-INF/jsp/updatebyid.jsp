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
<br><form action="${pageContext.request.contextPath}/user/upresult?ID=${student.ID}" method="post">
    姓名:<br><input type="text" name="name" value="${student.name}"><br>
    QQ:<br><input type="text" name="QQ" value="${student.QQ}"><br>
    线上学号:<br><input type="text" name="onlineNumber" value="${student.onlineNumber}"><br>
    毕业时间:<br><input type="text" name="enrollmentTime" value="${student.enrollmentTime}"><br>
    职业类型:<br><input type="text" name="professionType" value="${student.professionType}"><br>
    日报连接:<br><input type="text" name="dailyLink" value="${student.dailyLink}"><br>
    誓言:<br><input type="text" name="promise" value="${student.promise}"><br>
    师兄名称:<br><input type="text" name="brotherName" value="${student.brotherName}"><br>
    邮箱:<br><input type="text" name="mail" value="${student.mail}"><br>
    电话:<br><input type="text" name="phone" value="${student.phone}"><br>
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="提交">
</form><br>
<a href="/index.jsp">返回</a>
</body>
</html>
