<%--
  Created by IntelliJ IDEA.
  User: CH0918
  Date: 2018/7/8
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>增删改查页面</title>
</head>
<body>
<h2>添加学生信息</h2>
<form action="${pageContext.request.contextPath}/student" method="post" id="studentForm1" >
    <div>
        <input type="text" name="id" class="id" placeholder="学生id" />
    </div>
    <div>
        <input type="text" name="name" class="name" placeholder="学生姓名" />
    </div>
    <div>
        <input type="text" name="school" class="school" placeholder="毕业院校" />
    </div>
    <button id="submit1" type="submit">添加学生信息</button>
</form>
<h2>删除学生信息</h2>
<form action="${pageContext.request.contextPath}/student" method="post" id="studentForm2" >
    <input type="hidden" name="_method" value="DELETE">
    <div>
        <input type="text" name="id" class="id" placeholder="要删除学生的id" />
    </div>
    <button id="submit2" type="submit">删除学生信息</button>
</form>
<h2>更新学生信息</h2>
<form action="${pageContext.request.contextPath}/student/infomation" method="post" id="studentForm3" >
    <input type="hidden" name="_method" value="PUT">
    <div>
        <input type="text" name="id" class="id" placeholder="要更新的学生id" />
    </div>
    <div>
        <input type="text" name="name" class="name" placeholder="学生姓名" />
    </div>
    <button id="submit3" type="submit">更新学生信息</button>
</form>
<h2>查找学生信息</h2>
<form action="${pageContext.request.contextPath}/student/id" method="GET" id="studentForm4">
    <div>
        <input type="text" name="id" class="id" placeholder="要查找学生的id" />
    </div>
    <button id="submit4" type="submit">查找学生信息</button>
</form>
<h2>查找所有学生信息</h2>
<form action="${pageContext.request.contextPath}/allStudent" method="GET" id="studentForm5">
    <button id="submit5" type="submit">查找所有学生信息</button>
</form>
</body>
</html>
