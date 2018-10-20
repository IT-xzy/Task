<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0,  maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../../static/css/task9-3.css">
    <link rel="stylesheet" href="../../static/css/tab.css">
    <title>注册</title>
</head>
<body>
    <div id="parent" style="overflow: hidden; background: url(/static/img/timg.jpg) no-repeat;background-size: cover;" >
    <div id="child">
        <div id="tabs">
            <%--<form action="/registerResult" method="post">--%>
            <ul class='tabs clearfix'>
                <li>
                    <input type="radio" name="tabs" id="tab1" checked/>
                    <label for="tab1" class="tab-title">邮箱注册</label>

                    <div id="tab-content1" class="register tab-content">
                        <form action="/registerResult" method="post" name="formEmail" onsubmit="return formCheck1()">
                            <div class="input">
                                <label >账号 </label>
                                <input type="text" name="userName" placeholder="用户名" required>
                            </div>
                            <div class="input">
                                <label>密码</label>
                                <input type="password" id="pwd1" name="password" placeholder="密码" required>
                            </div>
                            <div class="input">
                                <label>确认密码</label>
                                <input type="password" id="pwd2" name="password1" placeholder="重复密码" required>
                            </div>

                            <div class="input">
                                <label>邮箱</label>
                                <input type="text" id="email" name="email" placeholder="邮箱" required onblur="checkEmail()">
                                <input type="submit" id="btnSendCodeEmail" name="btnSendCodeEmail" value="发送验证码" onclick="sendEmail()">
                                <div style="margin-left: 80px">
                                    <span id="emailTip"></span>
                                </div>
                            </div>

                            <div class="input">
                                <label>验证码</label>
                                <input type="text" id="EmailCheckCode" name="EmailCheckCode" maxlength="6" placeholder="验证码" required>
                                <div style="margin-left: 80px">
                                    <span id="EmailCheckCodeTip"></span>
                                </div>
                            </div>
                            <span style="text-align: center; color: red; font-size: small;"><i>${message}</i></span><br>
                            <div style="text-align: center">
                            <button>注册</button>
                            </div>
                        </form>
                    </div>
                </li>

                <li>
                    <input type="radio" name="tabs" id="tab2"/>
                    <label for="tab2"  class="tab-title">手机注册</label>

                    <div id="tab-content2" class="register tab-content">
                        <form action="/registerResult" method="post" name="formPhone" onsubmit="return formCheck2()">
                            <div class="input">
                                <label>账号 </label>
                                <input type="text" name="userName" placeholder="用户名" required>
                            </div>

                            <div class="input">
                                <label>密码</label>
                                <input type="password" id="pwd3" name="password" placeholder="密码" required>
                            </div>
                            <div class="input">
                                <label>确认密码</label>
                                <input type="password" id="pwd4" name="password2" placeholder="重复密码" required>
                            </div>

                            <div class="input">
                                <label>手机号</label>
                                <input type="tel" maxlength="11" minlength="11" id="phoneNumber" name="phoneNumber" placeholder="手机号必须11位" required onblur="checkPhone()">
                                <input type="submit" id="btnSendCode" name="btnSendCode" onclick="sendMessage()" value="发送验证码">
                                <div style="margin-left: 80px">
                                    <span id="phoneTip"></span>
                                </div>

                            </div>
                            <div class="input">
                                <label>验证码</label>
                                <input type="text" id="SmsCheckCode" name="SmsCheckCode" maxlength="6" placeholder="验证码" required>
                                <div style="margin-left: 80px">
                                <span id="SmsCheckCodeTip"></span>
                                </div>
                            </div>
                            <span style="text-align: center; color: red; font-size: small;"><i>${message}</i></span><br>
                            <div style="text-align: center">
                            <button>注册</button>
                            </div>
                        </form>
                    </div>
                </li>
            </ul>

        </div>
    </div>
</div>
<script type="text/javascript">
    //判断两次输入密码一致
    function formCheck1() {
        var pwd1 = document.getElementById("pwd1").value;
        var pwd2 = document.getElementById("pwd2").value;
        if (pwd1!=pwd2){
            alert("两次输入的密码不一致！");
            return false;
        }
        else
            return true;
    }
    function formCheck2() {
        var pwd3 = document.getElementById("pwd3").value;
        var pwd4 = document.getElementById("pwd4").value;
        if (pwd3!=pwd4){
            alert("两次输入的密码不一致！");
            return false;
        }
        else
            return true;
    }

</script>

    <%--邮箱验证--%>

    <script>
    //ajax验证邮箱是否已经存在
    function checkEmail() {
        var email = document.formEmail.email.value;
        var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;

        $("#btnSendCodeEmail").attr("disabled",true);
        if (email.length == ""){
            document.getElementById("emailTip").innerHTML ="<font color = 'red'>× 邮箱不能为空</font>";
            return false;
        }
        else if(email.length != "") {
            if(!re.test(email)){
                document.getElementById("emailTip").innerHTML = "<font color='red'>× 请输入有效的邮箱</font>";
                return false;
            } else {
                //向后台发送数据
                $.ajax({
                    url: "/checkEmail",//目标地址
                    data: {email: email},
                    type: "POST",
                    dataType: "text",
                    success : function (data) {
                        if (data == 0) {
                            $("#emailTip").html("<font color='red'>× 该邮箱已经被注册，请重新输入</font>");
                        }
                        else {
                            $("#emailTip").html("<font color='#339933'>√ 该邮箱可以注册，输入正确</font>");
                            $("#btnSendCodeEmail").removeAttr("disabled");
                        }
                    }
                });
                return true;
            }
        }
    }
    var InterValObj; //timer变量，控制时间
    var count = 120; //间隔函数，1秒执行
    var curCount1;//当前剩余秒数
    var emailCode = ""; //验证码
    var emailCodeLength = 6;//验证码长度

    function sendEmail() {
        curCount1 = count;
        var email = $("#email").val();
        if (email != "") {
            // 产生验证码
            for ( var i = 0; i < emailCodeLength; i++) {
                emailCode += parseInt(Math.random() * 9).toString();
            }
            // 设置button效果，开始计时
            $("#btnSendCodeEmail").attr("disabled", "true");
            $("#btnSendCodeEmail").val(curCount1 + "秒");
            InterValObj = window.setInterval(SetRemainTimeEmail, 1000); // 启动计时器，1秒执行一次
            // 向后台发送处理数据
            $.ajax({
                type: "POST", // 用POST方式传输
                dataType: "text", // 数据格式:JSON
                url: "/sendEmail", // 目标地址
                data: "email=" + email +"&emailCode=" + emailCode,
                error: function (XMLHttpRequest, textStatus, errorThrown) {},
                success: function () {}
            });
        }
        else{
            $("#emailTip").html("<font color='red'>× 邮箱不能为空</font>");
        }
    }


    //timer处理函数
    function SetRemainTimeEmail() {
        if (curCount1 == 0) {
            window.clearInterval(InterValObj);// 停止计时器
            $("#btnSendCodeEmail").removeAttr("disabled");// 启用按钮
            $("#btnSendCodeEmail").val("重发");
            emailCode = ""; // 清除验证码。如果不清除，过时间后，输入收到的验证码依然有效
        }else {
            curCount1--;
            $("#btnSendCodeEmail").val(curCount1 + "秒内输入");
        }
    }

    $(document).ready(function() {
        $("#EmailCheckCode").blur(function() {
            var EmailCheckCode = document.formEmail.EmailCheckCode.value;
//            var SmsCheckCodeVal = $("#SmsCheckCode").val();
            // 向后台发送处理数据
            $.ajax({
                url : "/checkEmailCode",
                data : {EmailCheckCode : EmailCheckCode},
                type : "POST",
                dataType : "text",
                success : function(data) {
//                    alert(data)
                    if (data == 1) {
                        $("#EmailCheckCodeTip").html("<font color='#339933'>√ 邮箱验证码正确，请继续</font>");
                    } else {
                        $("#EmailCheckCodeTip").html("<font color='red'>× 邮箱验证码有误，请核实后重新填写</font>");
                    }
                }
            });
        });
    });
    </script>

    <%--手机号码验证--%>

    <script>
    //ajax验证手机号码是否已经存在
    function checkPhone() {
        var phoneNumber = document.formPhone.phoneNumber.value;
        var re = /^1([3]|[5]|[8])[0-9]{9}$/;

        $("#btnSendCode").attr("disabled",true);
        if (phoneNumber.length == ""){
            document.getElementById("phoneTip").innerHTML ="<font color = 'red'>× 手机号码不能为空</font>";
            return false;
        }
        else if(phoneNumber.length != "") {
            if(!re.test(phoneNumber)){
                document.getElementById("phoneTip").innerHTML = "<font color='red'>× 请输入有效的手机号码</font>";
                return false;
            } else {
//                document.getElementById("phoneTip").innerHTML = "<font color = 'red'>√ 手机号码输入正确</font>";
                //向后台发送数据
                $.ajax({
                    <%--${pageContext.request.contextPath}--%>
                    url: "/checkPhone",//目标地址
                    data: {phoneNumber: phoneNumber},
                    type: "POST",
                    dataType: "text",
                    success : function (data) {
                    if (data == 0) {
                        $("#phoneTip").html("<font color='red'>× 该手机号码已经被注册，请重新输入</font>");
                    }
                    else {
                        $("#phoneTip").html("<font color='#339933'>√ 该手机号码可以注册，输入正确</font>");
                        $("#btnSendCode").removeAttr("disabled");
                    }
                }
            });
                return true;
            }
        }
    }
    var InterValObj; //timer变量，控制时间
    var count = 60; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    var code = ""; //验证码
    var codeLength = 6;//验证码长度

    function sendMessage() {
        curCount = count;
        var phoneNumber = $("#phoneNumber").val();
        if (phoneNumber != "") {
                // 产生验证码
                for ( var i = 0; i < codeLength; i++) {
                    code += parseInt(Math.random() * 9).toString();
                }
                // 设置button效果，开始计时
                $("#btnSendCode").attr("disabled", "true");
                $("#btnSendCode").val(curCount + "秒");
                InterValObj = window.setInterval(SetRemainTime, 1000); // 启动计时器，1秒执行一次
                // 向后台发送处理数据
                $.ajax({
                    type: "POST", // 用POST方式传输
                    dataType: "text", // 数据格式:JSON
                    url: "/sms", // 目标地址
                    data: "phoneNumber=" + phoneNumber +"&code=" + code,
                    error: function (XMLHttpRequest, textStatus, errorThrown) {},
                    success: function () {}
                });
            }
        else{
            $("#phoneTip").html("<font color='red'>× 手机号码不能为空</font>");
        }
        }


    //timer处理函数
    function SetRemainTime() {
        if (curCount == 0) {
            window.clearInterval(InterValObj);// 停止计时器
            $("#btnSendCode").removeAttr("disabled");// 启用按钮
            $("#btnSendCode").val("重发");
            code = ""; // 清除验证码。如果不清除，过时间后，输入收到的验证码依然有效
        }else {
            curCount--;
            $("#btnSendCode").val(curCount + "秒内输入");
        }
    }

    $(document).ready(function() {
        $("#SmsCheckCode").blur(function() {
            var SmsCheckCode = document.formPhone.SmsCheckCode.value;
//            var SmsCheckCodeVal = $("#SmsCheckCode").val();
            // 向后台发送处理数据
            $.ajax({
                url : "/checkCode",
                data : {SmsCheckCode : SmsCheckCode},
                type : "POST",
                dataType : "text",
                success : function(data) {
//                    alert(data)
                    if (data == 1) {
                        $("#SmsCheckCodeTip").html("<font color='#339933'>√ 短信验证码正确，请继续</font>");
                    } else {
                        $("#SmsCheckCodeTip").html("<font color='red'>× 短信验证码有误，请核实后重新填写</font>");
                    }
                }
            });
        });
    });
</script>
</body>
</html>
