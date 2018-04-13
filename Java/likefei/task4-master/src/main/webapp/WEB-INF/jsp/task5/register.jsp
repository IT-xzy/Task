<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/4/9
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="JavaScript">
    function isValidate(form){
        //得到用户输入的用户名和密码
        user_name=form.user_name.value;
        user_password=form.user_password.value;
        //接下来先验证用户名
        //如果用户名的长度小于六
        if(user_name.length<6){
            alert("用户名的长度小于六。");
            form.user_name.focus();
            return false;
        }

        //如果用户名的长度大于8
        if(user_name.length>8){
            alert("用户名的长度大于八。");
            form.user_name.focus();
            return false;
        }

        //接下来验证口令
        //如果密码的长度小于六
        if(user_password.length<6){
            alert("密码的长度小于六。");
            form.user_password.focus();
            return false;
        }

        //如果密码的长度大于8
        if(user_password.length>8){
            alert("密码的长度大于八。");
            form.user_password.focus();
            return false;
        }

        //密码与用户名不能相等
        if(user_password==user_name){
            alert("密码与用户名不能相等");
            form.user_password.focus;
            return false;
        }
    }
</script>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<h2 align="center">注册界面</h2>
<form name=form1 action="/register" method="post" onsubmit="return isValidate(form1)">
    <table align="center">
        <tr>
            <td>用户ID：</td>
            <td><input type="text" name="name" value="${user.name}">6~8位</td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password" value="${user.password}" >6~8位，且不能与用户ID相同</td>
        </tr>
        <tr>
            <td><input type="reset" value="重置"></td>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>