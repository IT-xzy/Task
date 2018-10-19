<%@page language="java" contentType="text/html; charset=UTF-8"  session="false" %>

<html>
<head>
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
</head>
<body>
<center>
    <br>
    <br>
    <h1>用户登录</h1>
    <form action="${pageContext.request.contextPath}/u/loginByUsernameSubmit" method="post">
        <table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
            <tr>
                <td><span>用户名</span></td>&nbsp;
                <td><input type="text" name="name" class="form-control"/></td>
            </tr>
            <tr>
                <td><span>密  码</span></td>&nbsp;
                <td><input type="password" name="password" class="form-control"/> </td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <input type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/u/register"><input type="button" value="注册"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/home"><input type="button" value="HOME"></a>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <a href="${pageContext.request.contextPath}/u/loginByPhone"><input type="button" value="使用手机登录"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/u/loginByEmail"><input type="button" value="使用邮箱登录"></a>
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
<!--jQuery(Bootstrap的JavaScript插件需要引入jQuery)-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!--包括所以已编译的插件-->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>