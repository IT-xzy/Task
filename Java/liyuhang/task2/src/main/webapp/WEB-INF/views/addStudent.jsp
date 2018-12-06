<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<html>
<head>
    <title>添加页面</title>
</head>
<body>
<div style="width:100%;text-align:center">
    <form  method="post" action="/u/student">
        学生学号：<input name="studentNumber" value="" type="text" placeholder="请输入学号" style="min-width:12%;"> <br><br>
        学生姓名：<input name="name" value="" type="text" placeholder="请输入姓名" style="min-width:12%;"> <br><br>
        学生QQ：<input name="qq" value="" type="text" placeholder="请输入QQ号" style="min-width:12%;"> <br><br>
        入门誓言：<input name="wish" value="" type="text" placeholder="请输入您的入学誓言" style="min-width:12%;"> <br><br>
        毕业院校：<input name="school" value="" type="text" placeholder="请输入毕业院校" style="min-width:12%;"> <br><br>
        入学时间：<input name="enrolmentTime" value="2018/11/25" type="date" style="min-width:12%;"> <br><br>
        <%--修真类型：<input name="type" value="" type="text" placeholder="请输入选择的职业方向" style="min-width:12%;"> <br><br>--%>
        修真类型： <select name="type" style="min-width:12%;">
        <option value="java">java</option>
        <option value="css">css</option>
        <option value="ui">ui</option>
        <option value="运营">运营</option>
        <option value="测试">测试</option>
        <option value="动画师">动画师</option>
        <option value="js">js</option>
        <option value="python">python</option>
        <option value="Android">Android</option>
        <option value="ios">ios</option>
        <option value="op">op</option>
        </select> <br><br>
        了解渠道：<input name="knowFrom" value="" type="text" placeholder="请输入了解渠道" style="min-width:12%;"> <br><br>
        <input type="submit" value="添加学生信息" style="min-width:12%;"> <br><br>
        <input name="createAt" value="<%=System.currentTimeMillis()%>" type="hidden"> <br><br>
        <input name="updateAt" value="<%=System.currentTimeMillis()%>" type="hidden"> <br><br>

    </form>
</div>
</body>
</html>

