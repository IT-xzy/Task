<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>报名页面</title>
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
    <p id="signinTitle">上海报名</p>
    <hr>
    <p style="color: #009900" align="center">${user.username},欢迎报名线下。</p>
    <hr>
</div>
<c:if test="${user.phone != null}">
    <div>
        <form:form name="registration" action="/u/signin" method="post">
            姓名：<input name="name" type="text" ><br>
            课程：<select name="courseId">
            <OPTION value="1">后端</OPTION>
            <option value="2">前端</option>
            <option value="3">产品经理</option>
            </select><br>
            邮箱：<input type="email" name="email"><br>
            地址：<input type="text" name="address"><br>
            <input type="submit" value="报名">
        </form:form>
    </div>
</c:if>
<c:if test="${!empty user.email}">
    <div>
        <form:form name="registration" action="/u/signin" method="post">
            姓名：<input name="name" type="text" ><br>
            课程：<select name="courseId">
            <OPTION value="1">后端</OPTION>
            <option value="2">前端</option>
            <option value="3">产品经理</option>
            </select><br>
            地址：<input type="text" name="address"><br>
            电话：<input type="text" name="phone"><br>
            <input type="submit" value="报名">
        </form:form>
    </div>
</c:if>
</body>
</html>