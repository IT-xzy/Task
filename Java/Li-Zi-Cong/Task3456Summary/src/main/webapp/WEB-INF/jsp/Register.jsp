<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <link rel="stylesheet" media="screen" href="views/css/css.css"/>

    <script>

        //提交验证变量------------------------------------------
        // var submitLockVar =true;            //提交锁
        // var checkAccountResult=false;    //验证账号重复

        //计时器变量-------------------------------------------
        var initialTimei=5           //初始化计时器用
        var sec =initialTimei;      //计时用常量
        var timeStart;             //暂存计时器对象
        //----------------------------------------------------


        //====================================================
        //计时器
        function timer() {
            var temp = document.getElementById("sendEmailToken");
            temp.disabled = true;
            temp.style.backgroundColor = "red";
            sec-=1;
            temp.innerHTML=sec+"秒后再操作";
            if (sec==-1){
                sec=initialTimei;
                temp.style.backgroundColor="#27AE60";
                temp.innerHTML="再次发送邮件验证码";
                window.clearInterval(timeStart);
                temp.disabled=false;
            }
        }
        //====================================================



        //+++++++++++++++++++++++++++++++++++++++++
        //用户输入验证
        function check() {
            var account     = $('#account').val();
            var password    = $('#password').val();
            var password2   = $('#password2').val();
            var phone       = $('#phone').val();
            var email       = $('#email').val();
            alert("输入验证模块");
            if (account.length < 3){
                alert("账号不能少于3位");
                return 0;
            }else if (password.length < 3){
                alert("密码不能少于3位");
                return 0;
            }else if (password.toString() != password2.toString()){
                alert("重复输入的密码不一致")
                return 0;
            }else if(phone.length != 11){
                alert("请输入正确的手机号");
                return 0;
            }else if(email.indexOf("@") == -1){     //indexOf查询参数在字符串第几个出现，
                alert("请输入正确的电子邮箱地址");   // 如果没有返沪-1，所以可以用来判断是否有@
                return 0;
            }
            return 1;
        }
        //+++++++++++++++++++++++++++++++++++++++++


        //******************************************
        //提交验证
        // function temp() {
        //     $("#submit").attr("style","display:none;");
        // }

        // function submitLock() {
        //     var check = document.getElementById("submit");
        //     if (submitLockVar==true) {
        //         check.disabled = true;
        //         alert("注册锁定,请先提交验证码并通过验证");
        //     }else {
        //         check.disabled = false;
        //
        //     }
        // }

        function  checkToken() {
            $.ajax({
                type: "post",
                url: '${pageContext.request.contextPath}/checkToken',
                data:{addressee:$('#email').val(),code:$('#smsEmailtoken').val()},
                success: function (data) {
                    if (data == 1) {

                        // var check = document.getElementById("submit");
                        // check.disabled=false;
                        // submitLockVar = false;

                        // 文本框
                        // $('#account').attr('disabled',true);
                        // $('#password').attr('disabled',true);
                        // $('#password2').attr('disabled',true);
                        // $('#trueName').attr('disabled',true);
                        // $('#nickName').attr('disabled',true);
                        // $('#sex').attr('disabled',true);
                        // $('#phone').attr('disabled',true);
                        // $('#email').attr('disabled',true);
                        // $('#smsEmailtoken').attr('disabled',true);

                        // 按钮
                        // $('#lastPrevious').attr('disabled',true);
                        // $('#sendEmailToken').attr('disabled',true);
                        // $('#checkEmailToken').attr('disabled',true);

                        // $("#submit").attr("style","display:block;");

                        alert("验证码验证成功，可以提交注册");
                    }else if (data == 0){
                        alert("验证码验证失败");
                    }
                }
            });
        }


        //发送验证码
        function sendToken(){
            if (check()==1){
                $.ajax({
                    type: "post",
                    url: '${pageContext.request.contextPath}/checkAccount',
                    data: "checkAccount=" + $('#account').val(),    //根据元素ID取值
                    success: function (data) {
                        if (data == 1) {
                            alert("账号不可用");
                        }else if (data == 0) {
                            alert("账号可用");
                            $.ajax({
                                type: "post",
                                url: '${pageContext.request.contextPath}/code',
                                data: "addressee=" + $('#email').val(),   //根据元素ID取值
                                success: function (data) {
                                if (data == 1) {
                                    timeStart = window.setInterval(timer,1000);
                                    // var check = document.getElementById("submitLock");
                                    // check.disabled=false;
                                    alert("邮箱验证码发送成功");
                                }else  {
                                    timeStart = window.setInterval(timer,1000);
                                    alert(data.toString());
                                }
                                }
                            });
                        }
                    }
                });
            }else {
                var temp = document.getElementById("sendEmailToken");
                temp.style.backgroundColor="red";
                temp.innerHTML="请正确输入信息后再尝试发送验证码";
            }
        }
        //******************************************
    </script>
</head>
<html>
<body>
<form id="msform" method="post" action="/Register">
    <!-- progressbar -->
    <ul id="progressbar">
        <li class="active">Account Setup</li>
        <li>A little personal information about you.</li>
        <li>Some necessary verification</li>
    </ul>
    <!-- fieldsets -->
    <%--//------------------------------------------------%>
    <fieldset>
        <h2 class="fs-title">Create your account</h2>
        <h3 class="fs-subtitle">this is step 1</h3>

        <input type="text"     id="account"     name="account"  placeholder="account"/>
        <input type="password" id="password"    name="password" placeholder="password"/>
        <input type="password" id="password2"   name="password2"         placeholder="confirm password one more plz~"/>

        <input type="button" name="next" class="next action-button" value="Next" /><br><br>
        <a href="/Login" name="next" class="next action-button" value="Next">Already Owned Account ? </a><br><br>
    </fieldset>
    <%--//------------------------------------------------%>
    <fieldset>
        <h2 class="fs-title">Social Profiles</h2>
        <h3 class="fs-subtitle">this will be shown to your friends.</h3>

        <input type="text" id="trueName" name="trueName" placeholder="your true name"/>
        <input type="text" id="nickName" name="nickName" placeholder="what you want other body call you"/>
        <input type="text" id="sex" name="sex" placeholder="sex"/>

        <input type="button" name="previous" class="previous action-button" value="Previous"/>
        <input type="button" name="next" class="next action-button" value="Next"/>
    </fieldset>
    <%--//------------------------------------------------%>
    <fieldset>
        <h2 class="fs-title">Personal Details</h2>
        <h3 class="fs-subtitle">We will never sell it</h3>

        <input type="text" id="phone" name="phone" placeholder="yep,i need your phone!"/>
        <input type="text" id="email" name="email" placeholder="yep,i need your email!"/>
        <%--<textarea name="address" placeholder="Address"></textarea>--%>
        <input id="smsEmailtoken" type="text" name="smsEmailtoken" placeholder="验证码模块留空"/>

        <input id="lastPrevious" type="button" name="previous" class="previous action-button" value="Previous"/>
        <button id="sendEmailToken" type="button" class="previous action-button" onclick="sendToken()">SendToken</button>
        <button id="checkEmailToken" type="button" class="previous action-button" onclick="checkToken()">CheckToken</button>
        <input id="submit" type="submit" value="Submit" >
    </fieldset>
    <%--//------------------------------------------------%>
</form>


<script src="/views/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="/views/js/jquery.easing.min.js" type="text/javascript"></script>
<script src="/views/js/jQuery.time.js" type="text/javascript"></script>
<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>
</body>
</html>