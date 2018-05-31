<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/5/8
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

这是user个人资料界面，被shiro拦截，请修改个人资料
    <form id="form" enctype="multipart/form-data">
    用户名：<input id="name" name="name" type="text" value="${user.name}"/> </br>
    手机号：<input id="phonenumber" name="phonenumber" type="text" value="${user.phonenumber}"/> </br>
    邮箱：<input id="email" name="email" type="txt" value="${user.email}"/> </br>
    头像： <img id="head" src="" > </br>
    上传头像：<input id="image" name="image" type="file"/> </br>
    <input type="button" value="预览图片" onclick="readAsDataURL()" />
        <input type="button" id="update1" value="修改资料" onclick="update()"/>&nbsp;<input type="reset" value="重置">
    </form>
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    document.getElementById("head").src="${user.image}";
    function readAsDataURL(){
        //检验是否为图像文件
        var file = document.getElementById("image").files[0];
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
    function update() {
        var form = document.getElementById("form");
        var fd = new FormData(form);
        $.ajax({
            url: 'http://120.131.8.132/update',
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
                    alert("修改成功");
                }
            }
        })
    }
</script>
</body>
</html>
