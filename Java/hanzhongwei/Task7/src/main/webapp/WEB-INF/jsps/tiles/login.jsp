<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/5/24
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<h2 align="center">登录界面</h2>
<form name=form1 action="/login" method="post" onsubmit="return isValidate(form1)">
    <table align="center">
        <tr>
            <td>用户ID：</td>
            <td><input type="text" name="userName" >6~8位</td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" >6~8位</td>
        </tr>

        <tr>
            <td><input type="button"  value="注册" onclick="location.href='/main2'"></td>
            <td><input type="reset" value="重置"></td>
            <td><input type="reset" value="使用手机登录" onclick="location.href='/main1'"></td>
            <td><input type="submit" value="确定"></td>
        </tr>
    </table>
</form>