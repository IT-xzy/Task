<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/8/7
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<img src="img/IT修真院.gif" width="150" height="80">--%>

<%--<form action="${pageContext.request.contextPath}/image" method="post" enctype="multipart/form-data">--%>
    <%--<input type="file" name="image" value="点击上传图片"/>--%>
    <%--<input type="hidden" name="username" value="songwu"/>--%>
    <%--<input type="submit" value="上传"/>--%>
<%--</form>--%>
<img src="${image}" width="150" height="80">
${message}
<br><a href="${pageContext.request.contextPath}/u/personal">返回个人信息页面</a>
</body>
</html>
