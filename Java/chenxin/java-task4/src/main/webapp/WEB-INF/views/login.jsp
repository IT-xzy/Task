<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="l" beanName="com.ptteng.model.Login"/>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>登录页面</title>
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

        label {
            /* 确保所有label大小相同并正确对齐 */
            display: inline-block;
            width: 90px;
            text-align: right;
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

        textarea {
            /* 使多行文本输入框和它们的label正确对齐 */
            vertical-align: top;

            /* 给文本留下足够的空间 */
            height: 5em;
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
</head>
<body>
2018年4月21日20点59分
${message}
<form:form name="login" action="/login/loginProcess" method="post">
    <%--input元素中的value属性用于定义input元素在浏览器中显示时的默认填充值   --%>
    <div>
    用户名：<input name="username" type="text" value="chenxin"><br>
    </div>
    <div>
    密码：<input name="password" type="text"><br>
    </div>
    <div>
    <input type="submit" value="登录">
    </div>
    <%--<button>标签也是一个按钮，不过相比于的input的纯文本按钮，button允许更复杂的完整HTML内容。--%>
    <div class="button">
        <button type="submit">Send your message</button>
    </div>
</form:form>
<? js: document.getElementByName("login").submit();?>
</body>
</html>