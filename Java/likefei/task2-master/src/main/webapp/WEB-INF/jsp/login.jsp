<%@ page contentType="text/html; charset=gb2312"%>

<script language="JavaScript">
    function isValidate(form){
        //得到用户输入的用户名和密码
        userid=form.userid.value;
        userpass=form.userpass.value;

        //接下来先验证用户名
        //如果用户名的长度小于六
        if(userid.length<6){
            alert("用户名的长度小于六。");
            form.userid.focus();
            return false;
        }

        //如果用户名的长度大于8
        if(userid.length>8){
            alert("用户名的长度大于八。");
            form.userid.focus();
            return false;
        }

        //接下来验证口令
        //如果密码的长度小于六
        if(userpass.length<6){
            alert("密码的长度小于六。");
            form.userpass.focus();
            return false;
        }

        //如果密码的长度大于8
        if(userpass.length>8){
            alert("密码的长度大于八。");
            form.userpass.focus();
            return false;
        }

        //密码与用户名不能相等
        if(userpass==userid){
            alert("密码与用户名不能相等");
            form.userpass.focus;
            return false;
        }

    }
</script>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<h2 align="center">登录界面</h2>
<form name=form1 action="/task2/login" method="post" onsubmit="return isValidate(form1)">
    <table align="center">
        <tr>
            <td>用户ID：</td>
            <td><input type="text" name="userid" >6~8位</td>
        </tr>
        <tr>
            <td>口令：</td>
            <td><input type="password" name="userpass" >6~8位，且不能与用户ID相同</td>
        </tr>

        <tr>
            <td><input type="reset" value="重置"></td>
            <td><input type="submit" value="确定"></td>
        </tr>
    </table>
</form>
</body>
</html>