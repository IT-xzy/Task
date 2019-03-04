<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>

<%--<body>--%>
<%--<h2>Task7</h2>--%>
<%--<a href="${pageContext.request.contextPath}/home">去主页</a>--%>
<%--</body>--%>
<%--</html>--%>




<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>

<form id="uploadForm" enctype="multipart/form-data">
    <input id="file" type="file" name="file"/>
    <br><br><br>
    <button id="upload" type="button" onclick="uploadImg()" >测试上传图片到阿里云</button>
</form>
<script>
    /*
      ajax文件上传教程：
      https://blog.csdn.net/inuyasha1121/article/details/51915742
      */
    function uploadImg() {
        debugger
        $.ajax({
            type: "post",
            url: '/picture',
            data: new FormData($('#uploadForm')[0]),
            processData: false,
            contentType: false,
            success: function (data) {
                alert(data)
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
        });
    }
</script>
</body>
</html>
