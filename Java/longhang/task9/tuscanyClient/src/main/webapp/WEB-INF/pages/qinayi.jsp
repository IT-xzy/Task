<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/29
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/gotoAliyun" method="post" >
    <input  type="submit"  value="七牛迁至阿里">
    </form>
<form action="${pageContext.request.contextPath}/goQiniuyun" method="post" >
    <input  type="submit"  value="阿里迁至七牛">
</form>

</body>
</html>
