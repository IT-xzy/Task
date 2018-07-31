<%@page pageEncoding="UTF-8" %>
<html>
<body>
<a href="${pageContext.request.contextPath}/homePage">返回首页</a><br>
${message}
<div>
    <img src="${user.headURL}">
</div>
<form action="${pageContext.request.contextPath}/updateHeadResult" method="post" enctype="multipart/form-data">
    <input type="file" name="image" value="点击上传图片"/>
    <input type="hidden" name="username" value="${user.username}"/>
    <input type="submit" value="上传"/>
</form>
<form action="${pageContext.request.contextPath}/updateInformationResult" method="POST">
    <input type="hidden" name="username" value="${user.username}"/>
    性别：<input type="text" name="sex" value="${user.sex}">
    年龄：<input type="text" name="age" value="${user.age}">
    <input type="submit" value="修改">
</form>
<form action="${pageContext.request.contextPath}/updatePhoneNumberResult" method="POST">
    <input type="hidden" name="username" value="${user.username}"/>
    <input type="hidden" name="phoneNumber" value="${phone}">
    手机验证码是：<input type="text" name="code" size="12"/>
    <input type="submit" value="绑定"/>
</form>
<form action="${pageContext.request.contextPath}/updateMailAddressResult" method="POST">
    <input type="hidden" name="username" value="${user.username}"/>
    <input type="hidden" name="mailAddress" value="${mail}">
    邮箱验证码是：<input type="text" name="code" size="12"/>
    <input type="submit" value="绑定">
</form>

</body>
</html>