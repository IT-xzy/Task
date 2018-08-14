<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--核心标签 支持 c:--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--page 支持EL表达式 ${name}--%>
<%@ page isELIgnored="false" %>
<%--<html>--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
    <%--<title>File upload</title>--%>
    <%--<script src="${pageContext.request.contextPath}/stat/css/jquery.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div id="uploadForm">--%>
    <%--<img src='${pageContext.request.contextPath}/stat/images/${imaPath}' alt='' id='img' style="width: 100px;height: 100px;top: 20px;" /><br>--%>
    <%--<input id="file" type="file"/>--%>
    <%--<button id="upload" type="button" onclick="getUpload()">upload</button>--%>
<%--</div>--%>
<br/>
<br/>
<br/>
<br/>
<br/>
<%--${imgId}<br/>--%>
<br/>

<div style="margin: auto; width: 60%; padding-bottom:100px" class="form-group">

<%--<form action="/u/head_ico/${imgId}" method="post" enctype="multipart/form-data" >--%>
    <%--<input type="file" name="file" /><br/><br/>--%>
    <%--<button type="submit" class="btn btn-default">提交</button>--%>
<%--</form>--%>


<form role="form" action="/u/head_ico/${imgId}" method="post" enctype="multipart/form-data" >
    <div>${message}</div>
    <div class="form-group">
        <label for="inputfile">上传头像</label>
        <input  type="file" name="file" id="inputfile" class="btn btn-default">
        <p class="help-block">选择要上传的图片</p>
    </div>
    <button type="submit" class="btn btn-default">提交</button>
</form>
</div>
<%--<script type="text/javascript">--%>
    <%--function getUpload(){--%>
        <%--var formData = new FormData();--%>
        <%--formData.append('file', $('#file')[0].files[0]);--%>
        <%--$.ajax({--%>
            <%--url: 'http://localhost:8080/qiniu/upload',--%>
            <%--type: 'POST',--%>
            <%--dataType:"json",--%>
            <%--cache: false,--%>
            <%--data: formData,--%>
            <%--processData: false,--%>
            <%--contentType: false--%>
        <%--}).done(function(res) {--%>
            <%--alert(res.data);--%>
            <%--document.getElementById("img").src = res.data;--%>
        <%--}).fail(function(res) {--%>
            <%--alert("fail");--%>
        <%--});--%>
    <%--}--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>