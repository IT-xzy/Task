<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<html>
<head>
    <title>Login Update Verify</title>
</head>
<body>
<br><br>
<form action="loginUpdateVerify" method="post">
    <table align='center'>
        <tr>
            <td>Id:</td>
            <td><input type="text" name="loginId" value=""><br/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="loginPassword" value=""><br/></td>
        </tr>

        <tr>
            <td align='center'><input type="submit" value="修改密码"></td>
        </tr>
    </table>
</form>
</body>
</html>
