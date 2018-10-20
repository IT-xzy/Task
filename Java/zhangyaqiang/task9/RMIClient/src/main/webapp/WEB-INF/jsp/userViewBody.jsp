<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/9/19
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js">
    </script>
</head>

<body>
<div align="center" style="margin-top: 16px;margin-bottom: 16px;">
    <div id="view">
        <table border="1" align="center"
               style="border: 1px solid chartreuse;background:#dddddd;width:38%;height: 380px">
            <tr align="center">
                <th colspan="2">
                    个人信息展示
                </th>
            </tr>
            <tr align="center">
                <td>姓名</td>
                <td>
                    <c:if test="${(null==user.name)||(0>=user.name.length())}">
                        无
                    </c:if>
                    ${user.name}
                </td>
            </tr>
            <tr align="center">
                <td>头像</td>
                <td><img border="0" src="/u/headPhoto?key=${user.headPhoto}" alt="picture" width="108" height="108"
                         class="pimg"></td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <button id="button">编辑</button>
                </td>
        </table>
    </div>
    <div id="modify">
        <form action="/u/user/${user.username}" id="form1" method="post">
            <input type="hidden" name="_method" value="PUT">
            <input id="headPhoto" type="hidden" name="headPhoto" value="">
            <input id="username" type="hidden" name="username" value="${user.username}">
            <table border="1" align="center"
                   style="border: 1px solid chartreuse;background:#dddddd;width:38%;height: 380px ">
                <tr align="center">
                    <th colspan="2">
                        个人信息展示
                    </th>
                    <th>请输入修改后信息</th>
                </tr>
                <tr align="center">
                    <td>姓名</td>
                    <td>
                        <c:if test="${(null==user.name)||(0>=user.name.length())}">
                            无
                        </c:if>
                        ${user.name}
                    </td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr align="center">
                    <td>头像</td>
                    <td><img border="0" src="/u/headPhoto?key=${user.headPhoto}" alt="picture" width="108" height="108"
                             class="pimg"></td>
                    <td>
                        <br>
                        <input id="file" type="file" name="multipartFile" accept="image/jpeg"
                               onchange="verificationPicFile(this)"/>
                        <br>
                        <br>
                        <img id="show" src="" width="108" height="108" style="display: none" class="pimg">
                        <br>
                        <font color="red">请上传格式为".jpg", ".png",".jpeg"的图片，大小小于1MB。</font>
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="3">
                        <input type="button" value="确认修改" onclick="submitForm(this)">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<div id="outerdiv"
     style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
    <div id="innerdiv" style="position:absolute;">
        <img id="bigimg" style="border:5px solid #fff;" src=""/>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        document.getElementById("modify").style.display = "none";
        $(".pimg").click(function () {
            var _this = $(this);//将当前的pimg元素作为_this传入函数
            imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
        });
    })


    function imgShow(outerdiv, innerdiv, bigimg, _this) {
        var src = _this.attr("src");//获取当前点击的pimg元素中的src属性
        $(bigimg).attr("src", src);//设置#bigimg元素的src属性

        /*获取当前点击图片的真实大小，并显示弹出层及大图*/
        $("<img/>").attr("src", src).load(function () {
            var windowW = $(window).width();//获取当前窗口宽度
            var windowH = $(window).height();//获取当前窗口高度
            var realWidth = this.width;//获取图片真实宽度
            var realHeight = this.height;//获取图片真实高度
            var imgWidth, imgHeight;
            var scale = 0.8;//缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

            if (realHeight > windowH * scale) {//判断图片高度
                imgHeight = windowH * scale;//如大于窗口高度，图片高度进行缩放
                imgWidth = imgHeight / realHeight * realWidth;//等比例缩放宽度
                if (imgWidth > windowW * scale) {//如宽度扔大于窗口宽度
                    imgWidth = windowW * scale;//再对宽度进行缩放
                }
            } else if (realWidth > windowW * scale) {//如图片高度合适，判断图片宽度
                imgWidth = windowW * scale;//如大于窗口宽度，图片宽度进行缩放
                imgHeight = imgWidth / realWidth * realHeight;//等比例缩放高度
            } else {//如果图片真实高度和宽度都符合要求，高宽不变
                imgWidth = realWidth;
                imgHeight = realHeight;
            }
            $(bigimg).css("width", imgWidth);//以最终的宽度对图片缩放

            var w = (windowW - imgWidth) / 2;//计算图片与窗口左边距
            var h = (windowH - imgHeight) / 2;//计算图片与窗口上边距
            $(innerdiv).css({"top": h, "left": w});//设置#innerdiv的top和left属性
            $(outerdiv).fadeIn("fast");//淡入显示#outerdiv及.pimg
        });

        $(outerdiv).click(function () {//再次点击淡出消失弹出层
            $(this).fadeOut("fast");
        });
    }

    document.getElementById("button").onclick = function () {
        document.getElementById("view").style.display = "none";
        document.getElementById("modify").style.display = "block";
    }


    function showImg() {
        if (file) {
            var reads = new FileReader();
            img = file.files[0];
            reads.readAsDataURL(img);
            reads.onload = function (e) {
                document.getElementById("show").src = this.result;
                document.getElementById("show").style.display = "block";
            };
        }
    }

    //图片大小验证
    function verificationPicFile(file) {
        var fileSize = 0;
        var fileMaxSize = 1024;//1M
        var filePath = file.value;
        var fileTypes = [".jpg", ".png", ".jpeg"];
        if (filePath) {
            fileSize = file.files[0].size;
            var size = fileSize / 1024;
            if (size > fileMaxSize) {
                alert("文件大小不能大于1M！");
                file.value = "";
                document.getElementById("show").src = "";
                document.getElementById("show").style.display = "none";
                return false;
            } else if (size <= 0) {
                alert("文件大小不能为0M！");
                file.value = "";
                document.getElementById("show").src = "";
                document.getElementById("show").style.display = "none";
                return false;
            } else {
                var isNext = false;
                var fileEnd = filePath.substring(filePath.lastIndexOf("."));
                for (var i = 0; i < fileTypes.length; i++) {
                    if (fileTypes[i] == fileEnd) {
                        isNext = true;
                        showImg();
                        break;
                    }
                }
                if (!isNext) {
                    alert('不接受此文件类型');
                    file.value = "";
                    document.getElementById("show").src = "";
                    document.getElementById("show").style.display = "none";
                    return false;
                }
            }
        } else {
            document.getElementById("show").src = "";
            document.getElementById("show").style.display = "none";
            return false;
        }
    }


    function submitForm(button) {
        var username = document.getElementById("username").value;
        var formData = new FormData();
        formData.append('multipartFile', $('#file')[0].files[0]);
        $.ajax({
            type: "post",
            url: '/u/upload/' + username,
            data: formData,
            processData: false,
            contentType: false,
            success: function (data) {
                if (0 == data) {
                    document.getElementById("headPhoto").value = '/task7/user/headPhoto/' + username + '.jpg';
                    button.type = "submit";
                    document.getElementById("form1").submit();
                } else {
                    button.type = "submit";
                    document.getElementById("form1").submit();
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                button.type = "submit";
                document.getElementById("form1").submit();
            }
        });
    }
</script>
</html>
