<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/2/5
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<style>
    .submit{
        width:100px;
    }
</style>
<html>
<head>

    <title>注册页面</title>
    <script>
        function submit(){
            var cellphone = document.getElementById("cellphone");
            $.ajax({
                methods:'GET',
                url:'/phoneNumber',
                data:{cellphone:cellphone.value},
                success:function (result) {
                    console.log(result)
                }
            });

        }

        // var wait=60;
        // var input = document.getElementById("btn");
        // input.onclick = function () { time(); };
        // function time() {
        //     if(wait == 0){
        //         input.removeAttribute('disabled');
        //         input.value = '重新获取验证码';
        //         wait=60;
        //     }else{
        //         setTimeout(function () {
        //             wait--;
        //             input.setAttribute('disabled',true);
        //             input.value = wait + 's后重新获取';
        //             time();
        //         },1000)
        //
        //
        //     }
        // }

    </script>
</head>
<body>
用户注册
<form action="${pageContext.request.contextPath }/registered/u" method="post">
    <br>账号<input type="text" name="account">
    <br>密码<input type="text" name="password">
    <br>手机<input type="text" name="cellphone" id="cellphone">
    <%--<span id="checkResult"></span>--%>
    <br>邮箱<input type="text" name="email">
    <br>验证码<input type="text" name="code" class="submit">
    <input type="submit" name="注册" >
</form>

<%--<input type="button" id="btn" onclick="submit()" value="获取验证码" />--%>
<br><button onclick="submit()">发送验证码</button>
</body>
</html>
