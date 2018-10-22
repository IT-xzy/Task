<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" %>
<html>
<body>
<form action="${pageContext.request.contextPath}/admin" method="post">
    <p>
        账号： <input type="text" name="adminCode"/>
    </p>
    <p>
        密码： <input type="password" name="password"/>
    </p>
    <p>
        姓名： <input type="text" name="name"/>
    </p>
    <p>
        电话： <input type="text" name="telephone"/>
    </p>
    <p>
        邮箱： <input type="text" name="email"/>
    </p>
    <p>
        注册时间： <input type="text" name="enrolldate"/>
    </p>
    <input type="submit" value="保存"/>
</form>
</body>
</html>