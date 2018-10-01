<%--
  Created by IntelliJ IDEA.
  User: FGH
  Date: 2018/8/6
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<div id="head">
    <p>添加头像</p>
</div>

    <%--<form action="${pageContext.request.contextPath}/imgOSS" method="post" enctype="multipart/form-data">--%>
        <%--获取文件名字   <input name="fileName" id="name" type="file" /><br>--%>
        <%--<input type="submit" id = "tianjia" value="提交" onclick="sub()"/> <br>--%>
    <%--</form>--%>
<p><img  src="${login.photo}" alt="我是头像"/>
    <a href="${pageContext.request.contextPath}/upload/${login.id}">上传头像</a></p>
</p>
    <fieldset>
        <legend>用户详细</legend>
        <%--<input type="hidden" name="_method" value="PUT">--%>
        <input type="hidden" name="id" value="${login.id}"  /></br>
        <p>用户：<input type="text" name="phcount" value="${login.name}"  /></p>
        <p>邮箱：<input type="text" name="mail"  value="${login.email}"  />
            <a href="${pageContext.request.contextPath}/mail/${login.id}">绑定邮箱</a></p>
        <%--头像连接：<input type="" name="photo"  value="${login.photo}" /></p>--%>
    </fieldset>
    <h3><a href="${pageContext.request.contextPath}/users/">返回列表</a></h3>
</form>
</body>
</html>
