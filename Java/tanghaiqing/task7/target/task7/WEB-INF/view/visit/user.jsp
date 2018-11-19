<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tags" prefix="date" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>user</title>
</head>
<script type="text/javascript">
    function validate() {
        var a = document.getElementById("file");
        var form = document.getElementById("upload");
        if (a.value === "") {
            alert("请先选择图片");
            return false;
        }
        else {
            form.submit();
        }
    }
</script>
<body>
<div>
    <h1>我的信息展示</h1>

    <p>头像：<a href="${user.image}" target="_blank"><img src="${user.image}"></a><br>
    <form id="upload" action="user" method="post" enctype="multipart/form-data">
        <input id="file" type="file" name="image1" id="image">
        <input type="button" value="上传" onclick="validate()">
        <input type="text" hidden name="userName" value="${user.userName}"><br>
        <input type="text" hidden name="age" value="${user.age}"><br>
        <input type="text" hidden name="adminCode" value="${user.adminCode}"><br>
        <input type="text" hidden name="telephone" value="${user.telephone}"><br>
        <input type="text" hidden name="emailaccount" value="${user.emailaccount}"><br>
        <input type="text" hidden name="creatTime" value="${user.creatTime}"><br>
    </form>
    <br>
    姓名：${user.userName}<br>
    年龄：${user.age}<br>
    账号：${user.adminCode}<br>
    电话号码：${user.telephone}<br>
    邮箱账号：${user.emailaccount}<br>
    最近更新时间：<date:date value="${user.updateTime}"/><br>
    <form action="../migration" method="post">
        <input type="text" hidden value="http://phswsdp1x.bkt.clouddn.com/" name="address">
        <input type="submit" value="一键迁移七牛云">
    </form>
    <form action="../aliMigration" method="post">
        <input type="text" hidden value="https://tas7haiqing.oss-cn-beijing.aliyuncs.com/data/" name="address">
        <input type="submit" value="一键迁移阿里云">
    </form>
</div>
<!--footer-->
</body>
</html>