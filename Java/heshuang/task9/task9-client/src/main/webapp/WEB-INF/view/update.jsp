<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0,  maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../../static/css/task9-3.css">
    <title>头像修改</title>
</head>
    <body>

    <form action="/u/uploadFile" method="post" enctype="multipart/form-data">
            头像:<img id="pic" alt="" class="to" src="${user.headURL}">
            <input name="id" value="${user.id}" type="hidden"><br>
            <%--<input name="headURL" value="${user.headURL}" type="hidden"><br>--%>
            <input type="file" name="upload" id="file"><br>
            <%--<input type="hidden" value="put" name="_method"><br>--%>
            <input id="save" type="submit" value="保存">
    </form>

    <style>
        .to{width: 100px;height: 100px;border-radius: 100px}
    </style>
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#file").click(function(){
                document.getElementById("save").style.visibility="visible";
            });
        });

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

    </body>
</html>