<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<%--<head>--%>
    <%--<title>register</title>--%>
    <%--<meta http-equiv="pragma" content="no-cache">--%>
    <%--<meta http-equiv="cache-control" content="no-cache">--%>
    <%--<meta http-equiv="expires" content="0">--%>
    <%--<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">--%>
    <%--<meta http-equiv="description" content="This is my page">--%>
<%--</head>--%>
<body>
<center>
    <h1>用户注册</h1>
    <hr>
    <form name="" action="${pageContext.request.contextPath}/register" method="post">
        <br>用户 <input type="text" name="user" >
        <br>在线 <input type="text" name="online" >
        <br>工作 <input type="text" name="workers" >
        <br>密码 <input type="text" name="pass" >
        <input type="submit" name="注册" value="注册">
    </form>
</center>
</body>
</html>
