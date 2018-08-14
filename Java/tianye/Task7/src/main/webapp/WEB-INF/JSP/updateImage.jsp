<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/7/25
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.31.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#file_upload").change(function () {
                var $file = $(this);
                var fileObj = $file[0];
                var windowURL = window.URL || window.webkitURL;
                var dataURL;
                var $img = $("#preview");

                if (fileObj && fileObj.files && fileObj.files[0]) {
                    dataURL = windowURL.createObjectURL(fileObj.files[0]);
                    $img.attr('src', dataURL);
                } else {
                    dataURL = $file.val();
                    var imgObj = document.getElementById("preview");
                    // 两个坑:
                    // 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
                    // 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
                    imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                    imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

                }
            });
        });
    </script>

    </head>
    <body>
    <form id="itemForm"
    action="${pageContext.request.contextPath }/updateImage"
    method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="userId">用户名:</label>
            <input type="text" class="form-control" id="userId" name="userId" placeholder="输入用户名"/>
        </div>
    <tr>
    <td>图片</td>
    <td>
        <input type="file" name="item_pic" id="file_upload" accept="image/jpeg,image/png,image/gif"/>
        <div class="image_container">
                        <img id="preview" style="height:130px;width:117px;border-width:0px;" /></div>
        </td>


        <td colspan="2" align="center"><input type="submit" value="提交"/>
        </td>
        </tr>
        </form>

        </body>
        </html>



