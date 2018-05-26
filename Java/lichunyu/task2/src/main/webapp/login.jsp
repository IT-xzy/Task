<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-5-9
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LoginPage</title>
</head>

<body>
<form action="/success" method="post" style="text-align:center">
    <h2>Admin Login</h2>
    <p>
        <label>用户 </label> <input type="text"  name="username"
                                    tabindex="1" >
    </p>

    <p>
        <label>密码 </label> <input type="text"  name="password"
                                        tabindex="2" >
    </p>

    <p id="buttons">
        <input id="submit" type="submit" tabindex="3" value="register">
        <input id="reset" type="reset" tabindex="4" value="reset">
    </p>
</form>
</body>

</html>