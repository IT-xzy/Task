<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <title>报名内门</title>
<style type="text/css">

</style>
</head>
<body>

<div id="div1">
    <h2 align="center">请输报名信息</h2>

    <div id="right">
        <form id= "tf" action="${pageContext.request.contextPath}/u/dojoins" method="post">
            <%--<input type="file" name="img" id="file"/>--%>
            <%--<img id="allUrl" width="100px" height="150px"/>--%>


            <input type="file" onchange="previewFile()" name="img" id="file"/>
            <img src="" height="200" alt="Image preview..." >


                <p>真实姓名</p> <input type="text" name="name"/>
                <p>注册学号</p><input type="text" name="studentID">
                <p>手机号码</p>
                <input type="text" id = "phoneNumber" name="phone"><br>
                <input type="button" value="发送验证码" id="but">
                <input type="text" name="code" placeholder="验证码" required="required">
           <p>邮箱地址</p><input type="text" name="email">
           <p>职业选择</p> <select style="background-color:LavenderBlush" name="profession">
                <option value="java">java</option>
                <option value="web">web</option>
                <option value="ios">ios</option>
                <option value="android">android</option>
                <option value="pm">pm</option>
                <option value="qa">qa</option>
                <option value="ui">ui</option>
                <option value="python">python</option>
                <option value="css">css</option>
                <option value="js">js</option>
            </select>
                <input type="submit" value="提交"  >
        </form>
        <div id="one">
        <input type="button"  value="上传图片" onclick="img()" id="123"/>
        </div>
    </div>


</div>
<script>
    /*手机短信发送的函数*/
    $("#but").click(function () {
        var phone= document.getElementById("phoneNumber").value;
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/send",
            data: {"phoneNumber":phone},
            error: function (data) {
                alert("error")
            },
            success: function (data) {
                alert("验证码发送成功"+  phone)
            }

        });
    });

//图片异步上传
   function img() {
       /*图片函数*/
       var formData = new FormData();
       formData.append('file', $('#file')[0].files[0]);
        $.ajax({
            url: "${pageContext.request.contextPath}/SendimagesTool",
            type: "post",
            data: formData,
            processData:false,
            contentType:false,
            success: function(formData){

                alert("ok");

            },
            error:function (e) {
                alert("error"+e)
            }

        });
    }


//本地图片预览
    function previewFile() {
        var preview = document.querySelector('img');
        var file    = document.querySelector('input[type=file]').files[0];
        var reader  = new FileReader();

        reader.onloadend = function () {
            preview.src = reader.result;
        }
        if (file) {
            reader.readAsDataURL(file);
        } else {
            preview.src = "";
        }
    }


</script>




</body>
</html>
