<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-5-29
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        form{
            margin:0;
            background:#cccccc url(/images/email.png) no-repeat fixed center;
            font-family: 'PT Sans', Helvetica, Arial, sans-serif;
            background-size: 100%;
            text-align: center;
            color: #f0ffff;
        }
        /*输入框样式，去掉背景阴影模仿原生应用的输入框*/
        input{
            width:20%;
            height: 50px;
            border:none;
            padding-left:3px;
            font-size: 18px;
            color: #050505;
        }
        input:focus {
            outline: none;
        }
        /*登录按钮*/
        button{
            width: 150px;
            height: 40px;
            margin-top: 25px;
            margin-bottom: 25px;
            background: #1E90FF;
            border-radius: 10px;
            border:none;
            font-size: 18px;
            font-weight: 700;
            color: #fff;
        }

        button:hover {
            background: #79A84B;
            outline: 0;
        }
        /*输入框底部半透明横线*/
        .input_block {
            border-bottom: 1px solid rgba(0,0,0,.1);
        }

    </style>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>验证码</title>
</head>
<body>

<div>
<form action="/sms"  method="post"  style="text-align:center">
    <div>
        <div><h3>手机注册</h3></div>
        <div class="input_block">
            手机号<input type="text"  name="phoneNum" placeholder="请输入手机号">
        </div>
        <div class="input_block">
            邀请码<input type="text"  name="checkcode" placeholder="请输入注册邀请码">
        </div>
        <button onclick="">获取验证码</button>
    </div>
</form>
</div>

<div>
<form action="/email"  method="post"  style="text-align:center">
    <div>
        <div><h3>邮箱注册</h3></div>
        <div class="input_block">
            邮箱号<input type="text"  name="email" placeholder="请输入邮箱">
        </div>
        <div class="input_block">
            邀请码<input type="text"  name="checkcode" placeholder="请输入注册邀请码">
        </div>
        <button onclick="">获取验证码</button>
    </div>
</form>
</div>

</body>

</html>

