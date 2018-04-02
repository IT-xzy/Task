<%@page pageEncoding="UTF-8" contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>由id学生信息表</title>
</head>
<body>
<form name="studentEdit" action="/test/student/${student.id}" method="post">
    id:<input type="text" name="id" value="${student.id}"></br>
    姓名：<input type="text" name="name" value="${student.name}"></br>
    QQ：<input type="text" name="qq" value="${student.qq}"></br>
    职业：<input type="text" name="goal" value="${student.goal}"></br>
    报道时间：<input type="text" name="registration_date" value="${student.registration_date}"></br>
    毕业院校：<input type="text" name="graduated_from" value="${student.graduated_from}"></br>
    学号：<input type="text" name="number" value="${student.number}"></br>
    日报链接：<input type="text" name="daily_link" value="${student.daily_link}"></br>
    立愿：<input type="text" name="pledge" value="${student.pledge}"></br>
    辅导师兄：<input type="text" name="senior" value="${student.senior}"></br>
    从哪里了解到修真院：<input type="text" name="know_from" value="${student.know_from}"></br>
    <input type="hidden" value="put" name="_method">
    <input type="submit" value="修改">
</form>
</body>
</html>