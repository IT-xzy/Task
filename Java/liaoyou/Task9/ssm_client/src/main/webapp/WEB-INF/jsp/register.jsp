<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="false" %>

<html>
<head>
    <title>register</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
</head>
<body>
<center>
    <br>
    <br>
    <h1>用户注册</h1>
    <form action="${pageContext.request.contextPath}/u/registerSubmit" method="post">
        <table style="width:500px; margin:40px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="name" class="form-control"/></td>
            </tr>
            <tr>
                <td>密  码</td>
                <td><input type="password" name="password" class="form-control"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="注册"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="重置"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/u/login"><input type="button" value="LOGIN"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/home"><input type="button" value="HOME"></a>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <a href="${pageContext.request.contextPath}/u/registerPhone"><input type="button" value="使用手机注册"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/u/registerEmail"><input type="button" value="使用邮箱注册"></a>
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