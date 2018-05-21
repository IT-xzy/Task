<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>学员报名</title>

</head>
<body>
<h1 align="center">学员报名</h1>
<br>
<br>


<form method="post" action="${pageContext.request.contextPath}/subRegister">
    <table align="center" border="1" width="40%">
        <tr>
            <th align="center" colspan="2">修真院学员注册</th>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input id="userName" name="userName" value="" type="text" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input id="email" name="email" value="" type="text" placeholder="请输入邮箱"></td>
        </tr>
        <tr>
            <td>手机号</td>
            <td><input id="phone" name="phone" value="" type="text" placeholder="请输入手机号"></td>
        </tr>
        <tr>
            <td><button type="button" id="code">获取手机验证码</button></td>
            <td><input id="sms" name="smsCode" value="" type="text" placeholder="请输入短信验证码"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input id="password" name="password" value="" type="password" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td>重复密码</td>
            <td><input id="repeatPassword" name="repeatPassword" value="" type="password" onblur="checkPassword()" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">提   交</button>
            </td>
        </tr>
    </table>
</form>
<script src="/js/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        document.getElementById('code').addEventListener('click',function(){
            var phone = $("#phone").val();
            $.post("tencentsms",
                {
                    phone:phone
                },
                function(res){
                    console.log(res);
                    if (res.status == 1){
                        console.log();
                        alert("验证信息发送成功！");
                    } else {
                        alert(res.message);
                    }
            });
        });
    });
</script>
<script>
    function checkPassword() {
        var password = document.getElementById("password").value;
        var repeatPassword = document.getElementById("repeatPassword").value;
        if (password != repeatPassword){
            alert("密码不一致，请重新输入！");
        }
    }
</script>
</body>
</html>
