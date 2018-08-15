<!--注意isELIgnored是选择EL表达式是否输出-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<html>
<body>
<h2 align="center">请输入您的信息</h2>
<form action="${pageContext.request.contextPath}/updatepassword" method="post" align="center">
    <table align="center" width="800">
        <tr>
            <td align="right" width="300"><font color="#00bfff">*</font><strong>用户名:</strong></td>
            <td align="left"><input type="text" name="username" style="background-color:deepskyblue"
                                    value="${user.username}">${user.msg["username"]}</td>
        </tr>
        <tr>
            <td align="right"><font color="#00bfff">*</font><strong>原密码:</strong></td>
            <td align="left"><input type="password" name="oldpassword" style="background-color:deepskyblue"
                                    value="${user.password}">${user.msg.password}</td>
        </tr>
        <tr>
            <td align="right"><font color="#00bfff">*</font><strong>新密码:</strong></td>
            <td align="left"><input type="password" name="newpassword" style="background-color:deepskyblue"
                                    value="${newpassword}">${user.msg.newpassword}</td>
        </tr>
        <tr>
            <td align="right"><font color="#00bfff">*</font><strong>确认密码:</strong></td>
            <td align="left"><input type="password" name="repassword" style="background-color:deepskyblue"
                                    value="${user.repassword}">${user.msg.repassword}</td>
        </tr>
    </table>
    <div align="center">
        <%--<input type="hidden" value="PUT" name="_method">--%>
        <input type="submit" value="确定更改">
        <a href="${pageContext.request.contextPath}/login">
            <input name="修改密码" type="button" value="放弃更改"></a>
    </div>

</form>
</body>
</html>