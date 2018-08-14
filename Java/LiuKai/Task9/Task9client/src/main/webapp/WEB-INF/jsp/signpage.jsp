<%--
  Created by IntelliJ IDEA.
  User: Liu Kai
  Date: 2018/8/2
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--注册页面--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>电话：<span>${phoneNum}</span></p>
<%--<p>验证码：<span>${regCode}</span> 请在30分钟内填写</p>--%>
<%--<p>异常提示：<span>${exception}</span></p>--%>
<form action="/student" method="post">
    姓名：<input name="stuName" type="text" required="required"><br>
    密码：<input name="passWord" type="text" required="required"><br>
    <input name="phoneNum" value="${phoneNum}" type="hidden" >
    验证码：<input name="regCode" type="text" required="required"><br>
<input type="submit" >
</form>

</body>
</html>
