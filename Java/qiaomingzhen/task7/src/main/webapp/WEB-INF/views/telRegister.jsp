<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <script src="https://cdn.bootcss.com/jquery/3.3.0/jquery.min.js"></script>
    　
    <base href="${pageContext.request.contextPath}/">

</head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<body>
<div class="main">
    <form action="">
        <h2>请注册</h2>
        <div class="form-group">
            <label for="name">用户名</label>
            <input type="text" class="form-control" id="name" placeholder="请输入用户名">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" placeholder="请输入密码">
        </div>
        <div class="form-group">
            <label for="tel">手机号</label>
            <input type="text" class="form-control" id="tel" placeholder="请输入手机号">
        </div>
        <div class="form-group">
            <label for="code">验证码</label>
            <div class="sms"><input type="text" class="form-control smsCode" id="code"
                                    placeholder="请先获取验证码">
                <p id="randCode" class="smsCode1 btn-default">获取验证码</p></div>
        </div>
        <p id="submit" class="btn btn-default">Submit</p>
    </form>
</div>

<script>
    function isPoneAvailable(tel) {
        var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
        if (!myreg.test(tel)) {
            return false;
        } else {
            return true;
        }
    }

    var a = document.getElementById("randCode");
    a.onclick = function () {
        var tel = document.getElementById('tel').value;
        console.log(tel);

        if (!isPoneAvailable(tel)) {
            alert('手机号非法请重新输入！');
            return
        }
        $.ajax({
            type: "GET",
            url: "telCode",
            data: {tel: tel},
            async: false,
            dataType: 'JSON',
            success: function (result) {
                console.log(result)
                if (result.code === 0) {
                    alert('成功');
                    console.log(result);
                    // location.href = 'loginPage'
                } else {
                    alert(result.message)
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
            complete: function (XMLHttpRequest, textStatus) {
                this; // 调用本次 AJAX 请求时传递的 options 参数
            }
        })

    }
    $(function () {
        //按钮单击时执行
        $("#submit").click(function () {
            var obj = {
                // userPhoto:$('userPhoto').val(),
                name: $('#name').val(),
                password: $('#password').val(),
                tel: $('#tel').val(),
                code: $('#code').val()
            };
            //Ajax调用处理
            console.log(obj);
            $.ajax({
                type: "POST",
                url: "register",
                data: $.param(obj),
                async: false,
                dataType: 'JSON',
                success: function (result) {
                    console.log(result)
                    if (result.code === 0) {
                        alert('成功');
                        console.log(result);
                        location.href = 'loginPage'
                    }else {
                        alert(result.message)
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                },
                complete: function (XMLHttpRequest, textStatus) {
                    this; // 调用本次 AJAX 请求时传递的 options 参数
                }
            })
        });
    });

</script>
<style>
    .main {
        background-color: pink;
        width: 30%;
        position: absolute;
        left: 50%;
        top: 50%;
        padding: 2rem;
        transform: translate(-50%, -50%);
        padding: 2rem 5%;
        /*text-align: center;*/
    }

    .form-control {
        display: inline-block;
    }

    img {
        width: 100px;
    }

    .sms {
        width: 100%;
    }

    .smsCode {
        width: 60% !important;
        display: inline-block;

    }

    .smsCode1 {
        border: 0px;
        width: 30%;
        display: inline;
        /*background-color: aqua;*/
        border-radius: 1rem;
        padding: .3rem;
        /*color: white;*/
        /*background-color:#eeeeee;*/
    }

    .smsCode1:hover {
        /*color: white;*/
        /*background-color:#eeeeee;*/
    }


</style>
</body>
</html>