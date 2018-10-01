<%--
  Created by IntelliJ IDEA.
  User: FGH
  Date: 2018/8/5
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div >
    邮箱绑定
</div>
<p id="p1"></p>
<form name="form1" action="${pageContext.request.contextPath}/sendMail" method="post">
        <input name="id" type="hidden" value="${userMail.id}"/>
    <div>
        <input  name="name"  type="text" placeholder="邮箱" autocomplete="off"/>
    </div>
    <%--<div>--%>
        <%--<input name="RandCode" id="code_btn" type="text" placeholder="验证码">--%>
        <%--<input type="button" id="btn"  value="获取验证码" onclick="sendMessage();"/>--%>
    <%--</div>--%>
    <div>
        <button type="submit" >确定</button>
    </div>
</form>
</body>
</html>
