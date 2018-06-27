<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 解决 JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS --%>
<%@ page isErrorPage="true" %>

<body>

<%-- 添加一个自定义tags, 将long类型的时间转为固定格式输出 --%>
<%@ taglib uri="/tags" prefix="date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 显示错误信息 有就提示  -->
<c:if test="${allErrors!=null}">
    <c:forEach items="${allErrors}" var="error">
        <font color="red">${error.defaultMessage}</font><br/>
    </c:forEach>
</c:if>
<%-- 获取id 取更新用户信息 --%>
<form action="${pageContext.request.contextPath }/admin/student/${studentCustom.id}"
      method="post">
    <%-- REST POST更新动作 --%>
    <input type="hidden" name="_method" value="PUT"/>
    <fieldset>
        <legend>编辑用户</legend>
        <table width="100%"
               style="table-layout:fixed;word-break:break-all;background:#f2f2f2">
            <tr id="name">
                <td>id</td>
                <td>用户名称</td>
                <td>手机号码</td>
                <td>QQ</td>
                <td>修真类型</td>
                <td>入学时间</td>
                <td>毕业院校</td>
                <td>线上id</td>
                <td>日报连接</td>
                <td>立愿</td>
                <td>优秀学员</td>
                <td>辅导师兄</td>
                <td>是否工作</td>
                <td>个人头衔</td>
                <td>操作</td>
            </tr>

            <tr>
                <td>${studentCustom.id}</td>
                <td><input name="stuName" value="${studentCustom.stuName}"></td>
                <td><input name="stuTelephone" type="number"
                           value="${studentCustom.stuTelephone}">
                </td>
                <td><input name="stuQq" type="number"
                           value="${studentCustom.stuQq}">
                </td>
                <td><input name="stuProfession"
                           value="${studentCustom.stuProfession}">
                </td>
                <td><input name="join_date"
                           value="<date:date value ="${studentCustom.join_date}"/>">
                </td>
                <td><input name="stuSchool" value="${studentCustom.stuSchool}">
                </td>
                <td><input name="online_id" value="${studentCustom.online_id}">
                </td>
                <td><input name="daily_url" value="${studentCustom.daily_url}">
                </td>
                <td><input name="declaration"
                           value="${studentCustom.declaration}">
                </td>
                <td><input name="isSuper" value="${studentCustom.isSuper}">
                </td>
                <td><input name="counselor" value="${studentCustom.counselor}">
                </td>
                <td><input name="isWork" value="${studentCustom.isWork}">
                </td>
                <td><input name="stuTitle" value="${studentCustom.stuTitle}">
                </td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </fieldset>
</form>

<form id="phone" method="get">
    <fieldset>
        <legend>手机验证</legend>
        <table table width="100%"
               style="table-layout:fixed;word-break:break-all;background:#f2f2f2">
            <input type="hidden" name="id" value="${studentCustom.id}"/>
            <tr>
                <td>手机号</td>
                <td><input name="telePhone"
                           value="${studentCustom.stuTelephone}"></td>
                <td><input type="button" value="发送验证码"
                           onclick="sub('${pageContext.request.contextPath }/SMS','短信发送','phone')">
                </td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input name="verifyCode" id="verifyCode" value=""></td>
                <td><input type="button" value="更新手机号"
                           onclick="sub('${pageContext.request.contextPath }/admin/verifySMS','更新','phone')">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<form id="email" method="get">
    <fieldset>
        <legend>邮箱验证</legend>
        <table table width="100%"
               style="table-layout:fixed;word-break:break-all;background:#f2f2f2">
            <input type="hidden" name="id" value="${studentCustom.id}"/>
            <tr>
                <td>邮箱</td>
                <td>邮箱验证状态</td>
                <td>操作</td>
            </tr>
            <tr>
                <td><input name="stuMail" value="${studentCustom.stuMail}"></td>
                <td><input disabled value="${studentCustom.stuMailState}"></td>
                <td><input type="button" value="验证邮箱"
                           onclick="sub('${pageContext.request.contextPath }/admin/sendMailDefault', '验证邮件发送','email')">
                </td>
            </tr>
        </table>
    </fieldset>
</form>

<form id="image" method="post" enctype="multipart/form-data">
    <fieldset>
        <legend>头像更新</legend>
        <table table width="100%"
               style="table-layout:fixed;word-break:break-all;background:#f2f2f2">
            <input type="hidden" name="id" value="${studentCustom.id}"/>
            <tr>
                <td>当前头像</td>
                <td>头像地址</td>
                <td>更新</td>
                <td>操作</td>
            </tr>
            <tr>
                <td><img src="${studentCustom.headurl}-icon" width="50" height="50"
                         onerror="this.src='${pageContext.request.contextPath }/static/images/687.png'">
                </td>
                <td><input disabled value="${studentCustom.headurl}"></td>
                <td>
                    <%-- 选择文件后在页面预览--%>
                    <img id="preview" width="50" height="50"
                         src="${studentCustom.headurl}-icon"
                         onerror="this.src='${pageContext.request.contextPath }/static/images/687.png'"/>
                    <input type="file" name="item_pic" id="input_file"
                           accept="image/gif,image/jpeg,image/jpg,image/png,image/svg"
                           onchange="imgPreview(this)">
                </td>
                <td><input type="button" value="提交" onclick="doUpload(${studentCustom.id})"/></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
<script>
    function doUpload(id) {
        var formData = new FormData();
        // console.log($('#image'));
        formData.append("item_pic", $('#input_file').get(0).files[0]);
        $.ajax({
            url: '${pageContext.request.contextPath }/admin/updateFile/' + id,
            type: 'POST',
            data: formData,
            async: true,
            cache: false,
            contentType: false,
            processData: false,
            success: function (returndata) {
                if(returndata){
                    alert('头像上传成功');
                    window.location.reload();
                }else alert('头像上传失败');
            },
            error: function (returndata) {
                alert('连接失败');
            }
        });
    }
</script>
<script>
    function imgPreview(fileDom) {
        //判断是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
        }
        //获取文件
        var file = fileDom.files[0];
        var imageType = /^image\//;
        //是否是图片
        if (!imageType.test(file.type)) {
            alert("请选择图片！");
            return;
        }
        //读取完成
        reader.onload = function (e) {
            //获取图片dom
            var img = document.getElementById("preview");
            //图片路径设置为读取的图片
            img.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
</script>
<script type="text/javascript">
    function sub(url, msg, id) {
        $.ajax({
            cache: true,
            type: "POST",
            url: url,
            data: $('#' + id).serialize(),// 你的formid
            async: true,
            error: function (request) {
                alert("请求错误: " + request.error);
            },
            success: function (data) {
                if (data) {
                    alert(name + "成功!");
                    window.location.reload();
                } else {
                    alert(name + "失败!");
                }
            }
        });
    }
</script>
