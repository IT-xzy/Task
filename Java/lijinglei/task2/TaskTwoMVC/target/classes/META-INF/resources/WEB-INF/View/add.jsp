<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>添加数据</title>
</head>
<body>
<h3><center><font color="#dc143c" size="10">添加信息</font></center></h3>
<center><form action="<%=request.getContextPath() %>/addInfo" method="post">
  <p>   姓    名：<input type="text" name="name"></p>
  <p>     Q  Q ：<input type="text" name="qq"></p>
  <p>   修真类型：<input type="text" name="studyType"></p>
  <p>   入学时间：<input type="text" name="enrollment"></p>
  <p>   毕业学校：<input type="text" name="graduateSchool"></p>
  <p>   线上学号：<input type="text" name="studentNum"></p>
  <p>   日报链接：<input type="text" name="dailyLink"></p>
  <p>   立   愿：<input type="text" name="wish"></p>
  <p>   审核师兄：<input type="text" name="checkBro"></p>
  <p>   了解方式：<input type="text" name="knowWay"> </p>
  <center><input type="submit" value="提交数据"><br>
    <a href="/index">返回首页</a></center>
</form></center>
</body>
</html>