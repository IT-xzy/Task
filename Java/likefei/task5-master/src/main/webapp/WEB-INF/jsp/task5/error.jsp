<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/4/12
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<img src="<%=request.getContextPath()%>/Static/image/your-name29.png">--%>
<div>${requestScope.message}</div>
<script language="JavaScript">
    console.log(hashMap['message']);
</script>
<br>
</body>
</html>
