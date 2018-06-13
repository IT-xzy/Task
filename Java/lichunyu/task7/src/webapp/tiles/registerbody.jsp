<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-6-1
  Time: 15:45
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
            color: #050505;
            font-size: 18px;
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

    <script>
        function getCode(url) {
            var xmlhttp;
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.open("GET",url,true);
            xmlhttp.send();
        }
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SMS Register</title>
</head>
<body>

<form action="register"  method="post"  modelattribute="user" style="text-align:center">
   <div>
         <div><h3>欢迎注册</h3></div>
        <div class="input_block">
            昵称： <input type="text"  name="name"  placeholder="英文开头，不多于15字符">
        </div>
        <div class="input_block">
            密码： <input type="text"  name="password"  placeholder="请设置6-20位密码">
        </div>
        <div class="input_block">
            扣扣： <input type="text"   name="qq"  placeholder="请输入8-13位有效QQ">
        </div>
        <div class="input_block">
           邮箱： <input type="text"   name="email"   value="${email}" placeholder="请输入有效邮箱">
        </div>
        <div class="input_block">
            手机： <input type="text"   name="phoneNum"   value="${phoneNum}" placeholder="请输入有效的手机号">
        </div>
       <div class="input_block">
           验证码： <input type="text"   name="code" placeholder="输入验证码" >
       </div>
        <button type="submit">注册</button>
    </div>
</form>
</body>
</html>
