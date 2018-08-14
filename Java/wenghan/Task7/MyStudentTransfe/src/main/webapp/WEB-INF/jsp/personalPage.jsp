<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/19
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>个人主页</title>
</head>
<body>
    <table>
        <tr>
            <td><img src="${line}${User.headPortrait}"></td>
        </tr>
        <tr>
            <td>姓名：${User.name}</td>
        </tr>
        <tr>
            <td>ID:${User.id}</td>
        </tr>
        <tr>
            <td>职业：${User.position}</td>
        </tr>
        <tr>
            <td>个人介绍：${User.personalProfile}</td>
        </tr>
    </table>
    <form action="${pageContext.request.contextPath}/u/User" method="post">
        <input type="hidden" name="id" value="${User.id}">
        <input type="text" name="name" placeholder="请输入你的名字">
        <input type="text" name="position" placeholder="请输入的职业">
        <input type="text" name="personalProfile" placeholder="请输入你的个人介绍">
        <input type="submit" value="更新个人资料">
        <input type="hidden" name="_method" value="PUT">
    </form>

    <form action="${pageContext.request.contextPath}/u/uploadFile" enctype="multipart/form-data" method="post">
        <input type="file" name="file" value="file">
        <input type="submit" value="上传图片">
    </form>

    <form action="${pageContext.request.contextPath}/u/updatePasswordGetVerification" method="post">
        <input type="text" name="password" placeholder="请输入你的新密码">
        <input type="submit" value="更新密码">
        <input type="hidden" name="_method" value="PUT">
    </form>

    <c:if test="${Jurisdiction}">
    <form action="${pageContext.request.contextPath}/changeOss" method="get">
        <input type="submit" value="${Oss}">
    </form>
    </c:if>

    <a href="${pageContext.request.contextPath}/">回到主页</a>
</body>
</html>
