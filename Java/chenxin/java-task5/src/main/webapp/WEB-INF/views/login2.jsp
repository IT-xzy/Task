<%@page contentType="text/html;charset=utf-8" isELIgnored="false" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div>
                ${message}<br>
            <h2>${message}</h2>
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
                <a href="/registration/register">注册</a>
                <%--<button>标签也是一个按钮，不过相比于的input的纯文本按钮，button允许更复杂的完整HTML内容。--%>
                <div class="button">
                    <button type="submit">Send your message</button>
                </div>
            </form:form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>