<%@page pageEncoding="UTF-8" %>
<html>
<body>
<a href="${pageContext.request.contextPath}/homePage">返回首页</a><br>
${message}
<div>
    <img src="${user.headURL}">
</div>
<div>您的个人信息如下：</div>
<div>
    <div>用户名:${user.username}</div>
    <div></div>
</div>
<div>
    <div>性别:${user.sex}</div>
    <div></div>
</div>
<div>
    <div>年龄:${user.age}</div>
    <div></div>
</div>
<div>
    <div>
        <form action="${pageContext.request.contextPath}/updateInformation">
            <input type="hidden" name="username" value="${user.username}">
            <input type="submit" value="修改信息">
        </form>
    </div>
</div>
<div>
    <div>手机:${user.phoneNumber}</div>
    <div>
        <form action="${pageContext.request.contextPath}/updatePhoneNumber">
            <input type="hidden" name="username" value="${user.username}">
            <input type="text" name="phoneNumber" size="15">
            <input type="submit" value="绑定手机">
        </form>
    </div>
</div>
<div>
    <div>邮箱:${user.mailAddress}</div>
    <div>
        <form action="${pageContext.request.contextPath}/updateMailAddress">
            <input type="hidden" name="username" value="${user.username}">
            <input type="text" name="mailAddress" size="15">
            <input type="submit" value="绑定邮箱">
        </form>
    </div>
</div>

</body>
</html>