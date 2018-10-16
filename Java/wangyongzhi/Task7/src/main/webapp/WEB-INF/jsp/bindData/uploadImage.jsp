<!--注意isELIgnored是选择EL表达式是否输出-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>上传头像</title>
</head>
<h2 align="center">上传头像</h2>
<body>
<table align="center" border="1" cellspacing="0">
    <tr size="4">
        <td align="center">
            <img height="400" width="300" src="${stu.image}"/>
        </td>
    </tr>
    <tr>
        <td align="center">
            <form action="${pageContext.request.contextPath}/u/updateImage" method="post"
                  enctype="multipart/form-data">
                <input type="file" name="file">${map.warning}
                <input type="submit" value="点击上传">
            </form>
        </td>
    </tr>
    <tr>
        <td align="center">
            <button type="button"><a href="${pageContext.request.contextPath}/u/showInfo">放弃更改</a></button>
        </td>
    </tr>
</table>

</body>
</html>
