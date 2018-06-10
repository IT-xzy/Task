<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2018/5/28
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>请先手机验证</h2>

        <form action="${pageContext.request.contextPath}/doMobile" method="post" name="loginFrom">
            <table>
                <tr>
                    <td>手机号码:</td>
                    <td><input type="text" name="mobileNumber"  /></td>
                </tr>
                <tr>
                    <td  colspan="2" align="center"><input type="submit" value="获取验证码" /></td>
                </tr>

            </table>
        </form>
<form action="${pageContext.request.contextPath}/doMobileCheck" method="post">
    <tr>
        <td>验证码:</td>
        <td><input type="password" name="validate"  /></td>
    </tr>
    <input type="submit" value="验证">
</form>
</body>
</html>