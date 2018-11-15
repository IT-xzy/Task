<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            $("#btn").click(function () {
                var phone = $("#ph").val();
                $.ajax({
                    type: "GET",
                    url: "captcha",
                    data: {
                        telephone: phone
                    }
                })
            })
        });
        $(document).ready(function () {
            $("#mail1").click(function () {
                var emailaccount = $("#mail").val();
                $.ajax({
                    type: "GET",
                    url: "mailCaptcha",
                    data: {
                        emailaccount: emailaccount
                    }
                })
            })
        });

        var countdown = 60;
        function settime(obj) {
            if (countdown === 0) {
                obj.removeAttribute("disabled");
                obj.value = "免费获取验证码";
                countdown = 60;
                return;
            } else {
                obj.setAttribute("disabled", true);
                obj.value = "重新发送(" + countdown + ")";
                countdown--;
            }
            setTimeout(function () {
                    settime(obj)
                }
                , 1000)
        }
    </script>
</head>
<body>
<div>

    <form action="registration" method="post">
        姓名：<label>
        <input type="text" name="userName"/>
    </label><br/>
        年龄：<label>
        <input type="number" name="age"/>
    </label><br/>
        账号：<label>
        <input type="text" name="adminCode"/>
    </label><br/>
        密码：<label>
        <input type="password" name="password"/>
    </label><br/>
        手机号：<label>
        <input type="text" id="ph" name="telephone"/>
    </label><br/>
        <label>
            验证码：<input type="text" name="code"><input type="button" id="btn" value="免费获取验证码" onclick="settime(this)"/>
        </label><br/>
        邮箱：<label>
        <input type="text" id="mail" name="emailaccount"/>
    </label><br/>
        邮件验证码：<label>
        <input type="text" name="mailCode">
    </label><input type="button" id="mail1" value="免费获取验证码" onclick="settime(this)"/><br/>
        <input type="submit" value="注册">
    </form>
    已注册，请<a href="logging">登录</a>
</div>
<!--footer-->
</body>
</html>