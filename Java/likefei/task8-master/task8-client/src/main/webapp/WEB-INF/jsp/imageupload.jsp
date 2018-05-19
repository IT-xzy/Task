<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/5/7
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        var result=document.getElementById("result");
        var file=document.getElementById("photo");

        //判断浏览器是否支持FileReader接口
        if(typeof FileReader == 'undefined'){
            result.InnerHTML="<p>你的浏览器不支持FileReader接口！</p>";
            //使选择控件不可操作
            file.setAttribute("disabled","disabled");
        }

        function readAsDataURL(){
            //检验是否为图像文件
            var file = document.getElementById("photo").files[0];
            if(!/image\/\w+/.test(file.type)){
                alert("看清楚，这个需要图片！");
                return false;
            }
            var reader = new FileReader();
            //将文件以Data URL形式读入页面
            reader.readAsDataURL(file);
            reader.onload=function(e){
                var result=document.getElementById("result");
                //显示文件
                result.innerHTML='<img src="' + e.target.result +'" alt="" />';
            }
        }

        function readAsBinaryString(){
            var file = document.getElementById("photo").files[0];
            var reader = new FileReader();
            //将文件以二进制形式读入页面
            reader.readAsBinaryString(file);
            reader.onload=function(f){
                var result=document.getElementById("result");
                //显示文件
                result.innerHTML=this.result;
            }
        }

        function readAsText(){
            var file = document.getElementById("photo").files[0];
            var reader = new FileReader();
            //将文件以文本形式读入页面
            reader.readAsText(file);
            reader.onload=function(f){
                var result=document.getElementById("result");
                //显示文件
                result.innerHTML=this.result;
            }
        }

        function uploadText() {
            var form = document.getElementById("form1");
            var fd = new FormData(form);
            $.ajax({
                url: 'http://120.131.8.132/image',
                type: 'POST',
                data: fd,
                processData: false,
                contentType : false,
                dataType: 'json',
                success:function (JsonResult) {
                    if (!JsonResult.code == 0){
                        alert(JsonResult.message);
                    }
                    else {
                        alert("注册成功");
                        var url = JsonResult.data;
                        document.getElementById("image").setAttribute("src",url);
                }
                }
            })
        }

    </script>
    <form name="form1" id="form1" enctype="multipart/form-data">
        <label>请选择一个文件：</label>
        <input type="file" id="photo" name="photo"/>
        <input type="button" value="读取图像" onclick="readAsDataURL()" />
        <input type="button" value="读取二进制数据" onclick="readAsBinaryString()" />
        <input type="button" value="读取文本文件" onclick="readAsText()" />
        <input type="button" value="上传图片" onclick="uploadText()" />
    </form>

    <div id="result" name="result"></div>

    <img id="image">

</head>
<body>

</body>
</html>
