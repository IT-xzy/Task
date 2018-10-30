<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
<json:property name="student" value="第二个tomcat"></json:property>
<json:object name="student1">
<json:property name="姓名" value="李四"/>
<json:property name="序号" value="001"/>
</json:object>
<json:array name="t1">
<json:property name="姓名" value="李四"/>
<json:property name="姓名" value="张三"/>
</json:array>
</json:object>
<html>

<script>
var gareen = {"name":"盖伦","hp":616};
  
document.write("英雄: "+gareen.name);
document.write("血池: "+gareen.hp);
</script>
<body>
<h2>Hello World!</h2>
<br>
<a href="./student">student</a>
<br/>
<br/>
<a href="./home">IT修真院</a>
</body>
</html>
