<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/30
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="date" class="java.util.Date"/>
<%@ taglib uri="/tags" prefix="zhh"%>
<style>
    .to{width: 100px;height: 100px;border-radius: 100px}
</style>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#sign").click(function(){
            document.getElementById("save").style.visibility="visible";
        });
        $("#file").click(function(){
            document.getElementById("save").style.visibility="visible";
        });
        $("#nam").click(function(){
            document.getElementById("save").style.visibility="visible";
        });
    });
</script>
<script type="text/javascript">
    $(document).ready(function() {
        var obj = document.getElementById("file");//input file对象 必须用document.get

        $("#file").change(function () {
            $("#pic").attr("src", getObjectURL(obj));//将图片的src变为获取到的路径
        })
        function getObjectURL(node) {
            var imgURL = "";
            try {
                var file = null;
                if (node.files && node.files[0]) {
                    file = node.files[0];
                } else if (node.files && node.files.item(0)) {
                    file = node.files.item(0);
                }
                //Firefox 因安全性问题已无法直接通过input[file].value 获取完整的文件路径
                try {
                    //Firefox7.0
                    imgURL = file.getAsDataURL();
                    //alert("//Firefox7.0"+imgRUL);
                } catch (e) {
                    //Firefox8.0以上
                    imgURL = window.URL.createObjectURL(file);
                    //alert("//Firefox8.0以上"+imgRUL);
                }
            } catch (e) {      //这里不知道怎么处理了，如果是遨游的话会报这个异常
                //支持html5的浏览器,比如高版本的firefox、chrome、ie10
                if (node.files && node.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        imgURL = e.target.result;
                    };
                    reader.readAsDataURL(node.files[0]);
                }
            }
            return imgURL;
        }
    })
</script>
<html>
<head>
    <title></title>
</head>
<body>
<main>
<form action="/personal" method="post" enctype="multipart/form-data">
    注册手机号:<input type="text" name="phone" value="${c.phone}" readonly="true"><br><br>
    用户名:<input type="text" id="nam" name="name" value="${c.name}"><br><br>
    头像:<img id="pic" alt="" class="to" src="${c.img}"><input type="file" name="upload" id="file" ><br><br>
    注册时间:<zhh:date value="${c.create_at}"/><br><br>
    签名:<input id="sign" type="text" name="sign" value="${c.sign}"><br><br>
    <input type="hidden" name="id" value="${c.id}">
    <input type="hidden" name="password" value="${c.password}">
    <input id="save" type="submit" value="保存" style="visibility: hidden">
</form>
</main>
</body>
</html>
