﻿
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆界面</title>
    <%--<link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css">--%>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <%--<link rel="stylesheet" type="text/css" href="/css/userpanel.css">--%>
    <link rel="stylesheet" type="text/css" href="/css/jquery.ui.all.css">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
    <script type="text/javascript" src="js/jQuery.js"></script>
    <script src="/js/jquery.notice.js"></script>
</head>

<body class="login">

<div class="login_m">
    <div class="login_logo"><h1>上传图片界面</h1></div>
    ${返回通知}
    <div class="login_boder">
        <div class="login_padding">

            <form action="/upImage" enctype="multipart/form-data" method="POST">
            <label>
                <img id="img" width="200px" height="200px">
                <input type="file" name="file" id="file"  onchange="imgPreview(this)"/>
                <%--<button>上传</button>--%>
                <input type="submit" name="" id="input" value="上传">
            </label>

        </form>



        </div>
        <!--login_padding  Sign up end-->
    </div><!--login_boder end-->
</div><!--login_m end-->
<br> <br>




