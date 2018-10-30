<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="false" isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>register</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nav.css"/>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">HOME</a>
        </div>
        <div class="navbar-header navbar-right">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/u/login">LOGIN</a>
        </div>
    </div>
</nav>

<div align="center">
    <h2 class="form-head">使用手机号注册</h2>
</div>

<div class="container">
    <div class="row">
        <%--col-md-4：表示此div占四等份--%>
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form action="${pageContext.request.contextPath}/u/registerByPhoneSubmit" method="post">
                <div class="form-group">
                    <label for="username">用户名</label> &nbsp;&nbsp; <span id="nameMsg"></span>
                    <%--required表示提交前此表单字段必填；autofocus表示加载页面时此表单自动获得焦点--%>
                    <input type="text" name="name" id="username" class="form-control" placeholder="请输入用户名" required autofocus>
                </div>
                <div class="form-group">
                    <label for="password1">密码</label>
                    <input type="password" name="password" id="password1" class="form-control" placeholder="请输入密码" required maxlength="16">
                </div>
                <div class="form-group">
                    <label for="password2">重复密码</label> &nbsp;&nbsp; <span id="password-tip"></span>
                    <input type="password" name="password2" id="password2" class="form-control" placeholder="请再次输入密码" required maxlength="16">
                </div>
                <div class="form-group">
                    <%--这里没有对手机号的输入类型做限制，即输入字母也行，若要实现此功能，那么需要绑定事件调用函数，在函数里使用正则表达式进行判断--%>
                    <label for="phone">手机号</label> &nbsp;&nbsp; <span id="phone-tip"></span>
                    <%--maxlength 对number类型无效，对tel和password有效--%>
                    <input type="tel" name="phone" id="phone" class="form-control" placeholder="请输入手机号" required maxlength="11" minlength="11">
                </div>
                <div class="form-group">
                    <button type="button" id="btnPhoneCode" class="btn btn-info">获取验证码</button>
                    <input type="tel" name="code" id="phoneCode" class="form-control" placeholder="请输入验证码" required minlength="6" maxlength="6"/>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success" id="btn-submit">注册</button>
                    <button type="reset" class="btn btn-success" id="btn-reset">重置</button>
                    <a class="btn btn-success" href="${pageContext.request.contextPath}/u/registerEmail" role="button">使用邮箱注册</a>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>

<script>
    /**
     * @Desciption: 用来判断用户名是否存在，通过ajax传输数据
     * @Param: username
     * @Return: 服务端返回 ture or false
     * @Author: jk-leo
     * @Date: 2018/9/12 20:04
     */
    function checkUsername() {
        var usernameElement = document.getElementById("username");
        var xmlHttp = new XMLHttpRequest();
        var username = usernameElement.value;
        xmlHttp.onreadystatechange = function () {
            // 判断xmlHttp的状态是否完毕
            if (xmlHttp.readyState === 4 && xmlHttp.status == 200){
                // 根据返回信息判断用户名是否存在
                if (xmlHttp.responseText == "true"){
                    document.getElementById("nameMsg").innerHTML = "<font color='red'>用户名已被注册！</font>";
                    // 关闭注册按钮，使其无法点击
                    document.getElementById("btn-submit").disabled=true;
                } else {
                    document.getElementById("nameMsg").innerHTML = "<font color='green'>账号可用！</font>";
                    // 开启按钮
                    document.getElementById("btn-submit").disabled=false;
                }
            }
        };
        // 定义传输方式
        var method = "POST";
        // 定义对应URL，加上时间戳能使URL每次都是新的，避免浏览器缓存的干扰
        var url = "${pageContext.request.contextPath}/u/checkName?"+new Date().getTime();
        // 准备请求，true代表开启异步
        xmlHttp.open(method,url,true);
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        if (username===undefined || username===null || username===""){
            document.getElementById("nameMsg").innerHTML = null;
        } else {
            // 使用post，需要发送参数，若使用get，则发送null，因为参数写在URL里
            xmlHttp.send("username="+username);
        }
    }
    var usernameElement = document.getElementById("username");
    usernameElement.addEventListener("blur",checkUsername,false);
</script>
<script>
    /**
     * @Desciption: 用以校验用户两次输入的密码是否一致
     * @Param: 两次输入的密码值
     * @Return: null
     * @Author: jk-leo
     * @Date: 2018/9/12 21:20
     */
    function checkSamePassword(){
        var password1 = document.getElementById("password1").value;
        var password2 = document.getElementById("password2").value;
        if (password1 !== password2){
            document.getElementById("password-tip").innerHTML = "<font color='red'>两次输入密码不一致，请重新输入</font>";
            document.getElementById("btn-submit").disabled = true;
        } else {
            document.getElementById("password-tip").innerHTML = null;
            document.getElementById("btn-submit").disabled = false;
        }
    }
    var password2Element = document.getElementById("password2");
    password2Element.addEventListener("blur",checkSamePassword, false);
</script>
<script>
    /**
     * @Desciption: 验证码倒计时，时间为60秒，每秒执行一次此函数
     * @Param: 无
     * @Return: 无
     * @Author: jk-leo
     * @Date: 2018/9/16 18:40
     */
    var countdown = 60;
    function settime() {
        var btnPhoneCode = document.getElementById("btnPhoneCode");
        if (countdown == 0){
            btnPhoneCode.disabled = false;
            btnPhoneCode.innerHTML = "重新获取验证码";
            countdown = 5;
        } else {
            btnPhoneCode.disabled = true;
            btnPhoneCode.innerHTML = "重新发送("+countdown+")";
            countdown --;
            setTimeout(function () {
                settime()
            },1000)  // 一秒钟执行一次settime函数
        }
    }

    /**
     * @Desciption: 将手机号传入服务端，若手机号已被其他用户注册，要求用户重新输入手机号，否则服务端生成验证码并通过第三方发送短信给用户
     * @Param: 手机号
     * @Return: 若手机已被注册使用，要求用户输入新手机号
     * @Author: jk-leo
     * @Date: 2018/9/12 22:28
     */
    function sendPhoneCode() {
        var phone = document.getElementById("phone").value;
        // 判断手机号是否为空、非数字、非11位
        if(phone=="" || isNaN(phone) || phone.length!=11){
            alert("请填写正确的手机号！");
            return false;
        }
        var xmlHttpRequest =  new XMLHttpRequest();
        xmlHttpRequest.onreadystatechange = function () {
            if (xmlHttpRequest.readyState===4 && xmlHttpRequest.status ===200){
                if (xmlHttpRequest.responseText == "true"){
                    document.getElementById("phone-tip").innerHTML = "<font color='red'>此手机号已被注册</font>";
                    // 关闭注册按钮
                    document.getElementById("btn-submit").disabled = true;
                } else {
                    alert("已发送验证码");
                    settime();
                    // 清空提示信息
                    document.getElementById("phone-tip").innerHTML = null;
                    // 打开注册按钮
                    document.getElementById("btn-submit").disabled = false;
                }
            }
        };
        var method = "POST";
        var url = "${pageContext.request.contextPath}/u/sendPhoneCode?" + new Date().getTime();
        xmlHttpRequest.open(method,url,true);
        xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        if (phone===undefined || phone===null || phone===""){
            document.getElementById("phone-tip").innerHTML = null;
        } else {
            // 使用post，需要发送参数，若使用get，则发送null，因为参数写在URL里
            xmlHttpRequest.send("phone="+phone);
        }
    }
    var btnPhoneCodeElement = document.getElementById("btnPhoneCode");
    btnPhoneCodeElement.addEventListener("click",sendPhoneCode,false);
</script>

<!--jQuery(Bootstrap的JavaScript插件需要引入jQuery)-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!--包括所以已编译的插件-->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>