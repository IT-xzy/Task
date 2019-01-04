<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传图片</title>
</head>
<body>
<script type="text/javascript">
    function validate()
    {
        var a=document.getElementById("file");
        var form=document.getElementById("upload");
        if(a.value===""){
            alert("请先选择图片");
            return false;
        }
        else{
            form.submit();
        }
    }
</script>
<h1 align="center">图片上传与下载</h1>
<p>

        <a href="${imgUrl}" target="_blank"><img  src="static/images/thumbImages/${thNameUrl}" /><img src="${imgUrl}" ></a>
            
       

</p>
<form id="upload" action="${pageContext.request.contextPath}/thumb" method="post" enctype="multipart/form-data">
    <input id="file" type="file" name="image" id="image" >
    <input  type="button" value="上传" onclick="validate()">
</form>
</body>
</html>
