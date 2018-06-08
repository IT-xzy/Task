<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>注册页面</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>
<body>
<style>
    form {
        /* 居中表单 */
        margin: 0 auto;
        width: 400px;
        /* 显示表单的轮廓 */
        padding: 1em;
        border: 15px solid #CCC;
        border-radius: 1em;
    }

    form div + div {
        margin-top: 1em;
    }
    input, textarea {
        /* 确保所有文本输入框字体相同
           textarea默认是等宽字体 */
        font: 1em sans-serif;

        /* 使所有文本输入框大小相同 */
        width: 300px;
        box-sizing: border-box;

        /* 调整文本输入框的边框样式 */
        border: 1px solid #999;
    }

    input:focus, textarea:focus {
        /* 给激活的元素一点高亮效果 */
        border-color: #000;
    }


    .button {
        /* 把按钮放到和文本输入框一样的位置 */
        padding-left: 90px; /* 和label的大小一样 */
    }

    button {
        /* 这个外边距的大小与label和文本输入框之间的间距差不多 */
        margin-left: .5em;
    }
</style>
<div>
    <p style="color: #cf0003" align="center">${message}</p>
</div>
<div>
<form:form name="registration" action="/registration/registerProcess" method="post">
        用户名：<input name="username" type="text" ><br>
        密码：<input name="password" type="text" ><br>
        名：<input name="firstname" type="text" ><br>
        姓：<input  type="text" name="lastname"><br>
        邮箱：<input type="email" name="email"><br>
        地址：<input type="text" name="address"><br>
        电话：<input type="text" name="phone"><br>
    <input type="submit" value="注册">
</form:form>
</div>
</body>
</html>