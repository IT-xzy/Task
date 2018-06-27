<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Lambent Login Form a Flat Responsive Widget Template :: w3layouts</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">

    <!--	<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>-->

    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Lambent Login Form Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<h1>lin的登录表单</h1>
<div class="main-agileinfo">
    <h2>现在登录</h2>
    <form action="${pageContext.request.contextPath }/login" method="post">
        <input type="text" name="userName" class="userName" placeholder="Usename" required="required">
        <input type="password" name="passWord" class="password" placeholder="Password" required="required">
        <ul>
            <li>
                <input type="checkbox" id="brand1" value="">
                <label for="brand1"><span></span>记得我</label>
            </li>
        </ul>
        <a href="#">忘记密码?
        </a><br>
        <div class="clear"></div>
        <input type="submit" value="Login">
    </form>
</div>
<div class="footer-w3l">
    <p class="agile"> &copy; 2017 xxxxxxxxxxxxx</a></p>
</div>
</body>
</html>