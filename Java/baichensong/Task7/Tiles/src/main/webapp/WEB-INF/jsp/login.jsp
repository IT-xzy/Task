<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/login/style.css" rel='stylesheet' type='text/css'/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0);}, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<!-----start-main---->
<div class="main">
    <div class="login-form">
        <h1>Member Login</h1>
        <div class="head">
            <img src="${pageContext.request.contextPath}/login/user.png" alt=""/>
        </div>
        <form action="/doLogin" method="post">
            <input type="text" class="text" value="username" name="username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'USERNAME';}" >
            <input type="password" value="userpass" name="userpass" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
            <div class="submit">
                <input type="submit" onclick="myFunction()" value="LOGIN" >
            </div>
            <p><a href="${pageContext.request.contextPath}/z/start">点击注册</a></p>
        </form>
    </div>

    <!--//End-login-form-->
    <!-----start-copyright---->
    <div class="copy-right">
        <p>Copyright &copy; 2014.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
    </div>
    <!-----//end-copyright---->
</div>
<!-----//end-main---->

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>