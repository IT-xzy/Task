<%@page pageEncoding="UTF-8" contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>由id学生信息表</title>
</head>
<body>
<form action="/ssm/Student" method="post">
    <label style="width: 20px;text-align: right">id：</label><input name="id" value="${student.id}" type="text"><br>
    <label style="width: 20px;text-align: right">创建时间：</label><input name="create_at" value="${student.create_at}" type="text"><br>
    <label style="width: 20px;text-align: right">姓名：</label><input name="name" value="${student.name}" type="text"><br>
    <label style="width: 20px;text-align: right">QQ：</label><input name="qq" value="${student.qq}" type="text"><br>
    <label style="width: 20px;text-align: right">职业：</label><input name="professional" value="${student.professional}" type="text"><br>
    <label style="width: 20px;text-align: right">开始时间：</label><input name="start_time" value="${student.start_time}" type="text"><br>
    <label style="width: 20px;text-align: right">大学：</label><input name="university" value="${student.university}" type="text"><br>
    <label style="width: 20px;text-align: right">线上id：</label><input name="online_id" value="${student.online_id}" type="text"><br>
    <label style="width: 20px;text-align: right">日报链接：</label><input name="daily_url" value="${student.daily_url}" type="text"><br>
    <label style="width: 20px;text-align: right">入学宣言：</label><input name="oath" value="${student.oath}" type="text"><br>
    <label style="width: 20px;text-align: right">师兄：</label><input name="counselor" value="${student.counselor}" type="text"><br>
    <label style="width: 20px;text-align: right">城市：</label><input name="city" value="${student.city}" type="text"><br>
    <input type="hidden" value="put" name="_method">
    <input type="submit" value="修改">
</form>
</body>
</html>