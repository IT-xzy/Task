<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/12/012
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/studenttwo">
   <br>姓名 <input type="text" name="name"/>
    <br>QQ<input type="text" name="qq"/>
   <br>主修 <input type="text" name="major"/>
<input type="submit" value="增加">
</form>

</body>
</html>
