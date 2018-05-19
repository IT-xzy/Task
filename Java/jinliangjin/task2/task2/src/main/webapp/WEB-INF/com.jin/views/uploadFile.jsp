<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传文件</title>

</head>
<body>
<h2>文件上传</h2>
<!-- 上传是需要指定属性 enctype="multipart/form-data" -->
<!-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> -->
<form id="file" action="${pageContext.request.contextPath }/file/upload" method="post" enctype="multipart/form-data">
    <table width="100%" border=1>
        <tr>
            <td>文件简要信息</td>
            <td><input type="text" name="description"/></td>
        </tr>
        <tr>
            <td>选择文件</td>
            <td><input type="file" name="file"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="上传"/>
            </td>
        </tr>
    </table>

</form>
</body>

</html>