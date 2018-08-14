<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>表单验证</title>
    <script>
        function doValidate() {

            var chineseReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

            if(!chineseReg.test(document.forma.email.value)) {
                alert('请填写正确的邮箱!!');
                document.forma.email.focus();
                return false;
            }
            var phoneNumReg = /^(1\d{10})$/;
            if(!phoneNumReg.test(document.forma.phone.value)) {
                alert('请填写正确手机号码!!');
                document.forma.phone.focus();
                return false;
            }

            if(document.forma.password.value != document.forma.passwordTwo.value){
                alert('两次密码不一致!!');
                document.forma.password.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>

<form action="/user/insert" method="post" name="forma" onsubmit="return doValidate()">
    <input type="hidden" name="_method" value="PUT">
    姓名：<input type="text" name="username"><br/>
    邮箱：<input type="text" name="email"><br/>
    手机号码：<input type="text" name="phone"><br/>
    密码：<input type="text" name="password"><br/>
    再次确认密码：<input type="text" name="passwordTwo"><br/>
    <input type="submit" value="Submit">
</form>
</body>
</html>