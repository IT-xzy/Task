<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-6-1
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        form
        {
            background:#cccccc url(/images/123.jpg) no-repeat fixed center;
            background-size: 100%;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
</head>
<body>

<form action="register"  method="post" modelAttribute="user" style="text-align:center">
    <h2>Register</h2>
    <p>
        <label>用户： </label> <input type="text"  name="name"
                                   tabindex="1" >
    </p>
    <p>
        <label>密码： </label> <input type="text"  name="password"
                                   tabindex="2" >
    </p>

    <p id="buttons">
        <input id="submit" type="submit" tabindex="3" value="register">
        <input id="reset" type="reset" tabindex="4" value="reset">
    </p>
</form>
</body>
</html>
