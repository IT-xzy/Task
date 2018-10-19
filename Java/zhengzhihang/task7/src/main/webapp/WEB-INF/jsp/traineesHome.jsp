<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${trainees.name} home page</title>
</head>
<body>
<h1>个人主页</h1>
<p>头像：<img src="${url}"></p>

<p>name : ${trainees.name}</p>
<p>邮箱  : ${trainees.email}</p>
<p>手机  ：${trainees.phoneNumber}</p>
<p>公司  ：${trainees.company}</p>
<p>描述  ：${trainees.description}</p>
<p>
<form enctype="multipart/form-data" method="post" action=${pageContext.request.contextPath}"/u/uploadFile">
    <input type="file" name="uploadFile"/>
    <input type="submit" value="上传">
</form>

<form action=${pageContext.request.contextPath}"/u/c-oss" method="get">
    <input type="submit" value=${buttonName}>
</form>

</p>
</body>
</html>