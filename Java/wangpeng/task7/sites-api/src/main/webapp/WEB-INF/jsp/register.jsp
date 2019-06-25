<%--
  Created by IntelliJ IDEA.
  User: WP
  Date: 2019/6/16
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>手机注册</title>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/login.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/login2.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>修真院注册<sup>V2019</sup></h1>

<div class="login" id="login" style="margin-top:10px;">

    <div class="web_login">
        <form action="${pageContext.request.contextPath}/register" name="user" method="post"
              enctype="multipart/form-data">

            <ul class="reg_form" id="reg-ul">
                <div id="userCue" class="cue">欢迎！</div>

                <li>
                    <label for="name" class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="name" name="name" maxlength="16" class="inputstyle2"/>
                    </div>
                </li>

                <li>
                    <label for="password" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="password" name="password" maxlength="16" class="inputstyle2"/>
                    </div>
                </li>

                <li>
                    <label for="phone" class="input-tips2">手机号：</label>
                    <div class="inputOuter2">
                        <input type="text" id="phone" name="phone" maxlength="16" class="inputstyle2"/>
                    </div>
                </li>

                <li>
                    <label for="code" class="input-tips2">验证码：</label>
                    <div class="inputOuter2">
                        <input type="text" id="code" name="code" maxlength="10" class="inputstyle2"/>
                    </div>
                </li>

                <li>
                    <label for="mail" class="input-tips2">邮箱：</label>
                    <div class="inputOuter2">
                        <input type="text" id="mail" name="mail" maxlength="10" class="inputstyle2"/>
                    </div>
                </li>

                <li>
                    <label for="multipartFile" class="input-tips2">图片：</label>
                    <div class="inputOuter2">
                        <input type="file" id="multipartFile" name="multipartFile" maxlength="10"
                               class="inputstyle2"/>
                    </div>
                </li>

                <input type="submit" style="margin-top:5px;margin-left:85px;" class="button_blue"
                       value="同意协议并注册"/> <a href="#" class="zcxy" target="_blank">注册协议</a>
            </ul>
        </form>
    </div>

</div>

</body>
</html>
