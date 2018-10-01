<!--注意isELIgnored是选择EL表达式是否输出-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<html>
<body>
<h2 align="center">请输入注册信息</h2>
<form action="${pageContext.request.contextPath}/register" method="post" align="center">
    <table align="center" width="800">
        <tr>
            <td align="right" width="300"><font color="#00bfff">*</font><strong>用户名:</strong></td>
            <td align="left"><input type="text" name="username" style="background-color:deepskyblue"
                                    value="${user.username}">${user.msg["username"]}</td>
        </tr>
        <tr>
            <td align="right"><font color="#00bfff">*</font><strong>密码:</strong></td>
            <td align="left"><input type="password" name="password" style="background-color:deepskyblue"
                                    value="${user.password}">${user.msg.password}</td>
        </tr>
        <tr>
            <td align="right"><font color="#00bfff">*</font><strong>确认密码:</strong></td>
            <td align="left"><input type="password" name="repassword" style="background-color:deepskyblue"
                                    value="${user.repassword}">${user.msg.repassword}</td>
        </tr>
        <%--使用隐藏域存储生成的token--%>
        <%--
            <input type="hidden" name="token" value="<%=session.getAttribute("token") %>">
        --%>
        <%--使用EL表达式取出存储在session中的token--%>
        <input type="hidden" name="token" value="${token}"/>
    </table>
    <div align="center">
        <%--<input type="hidden" value="PUT" name="_method">--%>
        <input type="submit" value="注册并登陆">
        <a href="${pageContext.request.contextPath}/login">
            <input name="放弃注册" type="button" value="放弃注册"></a>
    </div>

</form>
</body>
</html>