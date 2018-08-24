<!--注意isELIgnored是选择EL表达式是否输出-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>

<html>
<head>
    <title>登录界面</title>
</head>
<body>
<h2 align="center">登录界面</h2>
<form name=form1 action="${pageContext.request.contextPath}/login" method="post">
    <table align="center">
        <tr>
            <td>用户ID：</td>
            <td><input type="text" placeholder="请输入用户名" size="20" name="username">6~8位</td>
        </tr>
        <tr>
            <td>口令：</td>
            <td><input type="password" placeholder="请输入密码" size="20" name="pd">6~8位，且不能与用户ID相同</td>
        </tr>

        <tr>
            <td><a href="${pageContext.request.contextPath}/register">
                <input name="注册" type="button" value="注册"></a>
                <a href="${pageContext.request.contextPath}/updatepassword">
                    <input name="修改密码" type="button" value="修改密码"></a>
            </td>
            <td><input type="reset" value="重置"><input type="submit" value="确定"></td>
        </tr>
        <%--判断输入的用户名和密码是否正确--%>
        <%--<input type="hidden" value="PUT" name="_method">,此处不能使用put--%>

        <%--注意这里因为要携带数据过去所以不使用超链接的形式--%>
        <%--<p style="text-align:center"><a href="${pageContext.request.contextPath}/homepage">登陆修真院主页</a><p/> --%>
        <tr>
            <td colspan="2" align="center">
                <img width="760" height="430" src=http://39.105.149.2/斯嘉丽.jpg alt="图片已丢失"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>