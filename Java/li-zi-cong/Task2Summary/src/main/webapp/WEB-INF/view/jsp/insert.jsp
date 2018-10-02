<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/7/27
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center;background: gray">新增信息2</h1><%--三目运算 --%>
<form action="/student" method="post">
    &nbsp;<input 	name="studentName"	value="${studentInfo.studentName}" type="text">	&nbsp;姓名*<br>
    &nbsp;<input 	name="qq"			value="${studentInfo.qq}" type="text">			&nbsp;QQ*<br>
    &nbsp;<input 	name="learnType"	value="${studentInfo.learnType}"type="text">	&nbsp;修真类型*<br>
    &nbsp;<input 	name="joinTime"		value="${studentInfo.joinTime}"type="text">	    &nbsp;预计入学时间 <br>
    &nbsp;<input 	name="school"		value="${studentInfo.school}"type="text">		&nbsp;毕业院校<br>
    &nbsp;<input 	name="studentID"	value="${studentInfo.studentID}"type="text">	&nbsp;学号 <br>
    &nbsp;<input 	name="link"	        value="${studentInfo.link}"type="text">	        &nbsp;日报链接 <br>
    &nbsp;<input 	name="motto"		value="${studentInfo.motto}"type="text">	    &nbsp;立愿 <br>
    &nbsp;<input 	name="brother"		value="${studentInfo.brother}"type="text">		&nbsp;辅导师兄 <br>
    &nbsp;<input 	name="knowFrom"	    value="${studentInfo.knowFrom}"type="text">	    &nbsp;从哪里得知修真院<br>
    <br>&nbsp;<input type="submit" 		value="${studentInfo.id==null?'新增':'修改' }" style="width: 161px" >
</form>
</body>
</html>
