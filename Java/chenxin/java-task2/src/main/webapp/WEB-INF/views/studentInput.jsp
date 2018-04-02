<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="command" class="com.ptteng.model.Student" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>新增学生</title>
</head>
<body>
<form:form name="input" action="/test/newOne" method="post">
    id:<form:input path="id"/></br>
    姓名：<form:input path="name"/></br>
    QQ：<form:input path="qq"/></br>
    职业：<form:input path="goal"/></br>
    报道时间：<form:input path="registration_date"/></br>
    毕业院校：<form:input path="graduated_from"/></br>
    学号：<form:input path="number"/></br>
    日报链接：<form:input path="daily_link"/></br>
    立愿：<form:input path="pledge"/></br>
    辅导师兄：<form:input path="senior"/></br>
    从哪里了解到修真院：<form:input path="know_from"/></br>
    <input type="hidden" value="put" name="_method">
    <input type="submit" value="新增">
</form:form>
</body>
</html>