<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>

    <script src="${pageContext.request.contextPath}/static/photo/jQuery.Form.js"></script>
    <script src="jQuery.Form.js" type="text/javascript"></script>

    <script type="text/javascript">
        function uploadPhoto() {
            $("#formPhoto").ajaxSubmit(
                {
                    type: 'POST',
                    url: '/u/upload',

                    success: function (data) {

                        if (data.length > 10) {
                            alert("上传成功");
                            $("#imgDiv").empty();
                            $("#imgDiv").html('<img src="' + data + "?x-oss-process=image/resize,w_100"+'"/>');
                            $("#imgDiv").show();
                        }
                        else {
                            alert("上传失败，检查文件格式");
                        }
                    },
                    error: function () {
                        alert("上传失败，请检查网络后重试");
                    }
                });
            return false; //阻止表单默认提交
        }
    </script>
</head>
<body>
<a href="/home">返回首页</a>
<br><br>
<div align="center">
    <form id="formPhoto" enctype="multipart/form-data">

        <label>用户名：</label><input type="readonly" name="name" value="${status}" readonly><br>
        <label>上传头像：</label><input type="file" name="file"><br>
        <td><input type="button" value="上传" onclick="uploadPhoto()"></td>

    </form>
    <br> <br> <br>
    <a href="/OssToCos">阿里云迁移到腾讯云</a>
    <br>
    <a href="/CosToOss">腾讯云迁移到阿里云</a>
    <br>
    <tr>
        <td colspan="2">
            <div id="imgDiv"></div>
        </td>
    </tr>

</div>
</body>
</html>