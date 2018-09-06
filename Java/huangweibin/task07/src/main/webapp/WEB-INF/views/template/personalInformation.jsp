<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/27
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>

<h4>个人信息</h4>
<li>
    <!-- 头像显示 -->
    <%--<img src="${headPhotourl}" style="width:100px; height: 100px;/">--%>
    <img height="108" width="108" src="${headPhotoURL}">
</li>
<li>
    用户名：${userlogin.name}
</li>
<li>
    手机号：${userlogin.phone_number}
</li>


<form id="uploadForm" enctype="multipart/form-data">
    -----------------------------------------------------------------------------
    <input id="file" type="file" name="file"/>
    <br><br><br>
    <button id="uploadToALi" type="button" onclick="uploadImgToALi()">点击上传(阿里云)</button>

    <button id="upload1ToQiNiu" type="button" onclick="uploadImgToQiNiu()">点击上传(七牛云)</button>
    <br>
    -----------------------------------------------------------------------------
    <br>

</form>

<div id="content" >
    <form id="migrate" name="migrate" >

        <%--<input id="migrateToALi" type="button" onclick="migrateToALi()">文件迁移至阿里云</input>--%>
        <input type="button" value="文件迁移到阿里云" style="color:#67bc49" onclick="migrateToALi()">
        <input type="button" value="文件迁移到七牛云" style="color:#67bc49" onclick="migrateToQiNiuYun()">

    </form>
</div>




<script>
    /*
      ajax文件上传教程：
      https://blog.csdn.net/inuyasha1121/article/details/`51915742
      */
    function uploadImgToALi() {
        debugger
        $.ajax({
            type: "post",
            url: '/uploadToAliYun',
            data: new FormData($('#uploadForm')[0]),
            processData: false,
            contentType: false,
            success: function (data) {
                alert(data)
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
        });
    }

    function uploadImgToQiNiu() {
        debugger
        $.ajax({
            type: "post",
            url: '/uploadToQiNiuYun',
            data: new FormData($('#uploadForm')[0]),
            processData: false,
            contentType: false,
            success: function (data) {
                alert(data)
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
        });
    }


</script>
<script type="text/javascript" language="JavaScript">
    function migrateToALi() {

        var targetOSS = "ALiYun";
        // alert("1")
        $.ajax({
            url:"/migrate",
            type:"POST",
            data:{
                targetOSS:targetOSS
            },
            success: function (data) {//如果调用成功
                alert(data);
            },
            error: function (data) {
                // //请求失败后执行的动作
                alert(data);
            }
        })

    }

    function migrateToQiNiuYun() {

        var targetOSS = "QiNiuYun";
        // alert("1")
        $.ajax({
            url:"/migrate",
            type:"POST",
            data:{
                targetOSS:targetOSS
            },
            success: function (data) {//如果调用成功
                alert(data);
            },
            error: function (data) {
                // //请求失败后执行的动作
                alert(data);
            }
        })

    }
</script>

</body>
</html>
