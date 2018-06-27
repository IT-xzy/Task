<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>表单的提交</title>

    <!--引入jq官网源码链接-->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>

<!-- 扩展-----用ajax 提交表单 json 到数据库 -->
<form id="fm" name="from" method="post">


    姓名<input type="text" name="name">
    QQ:<input type="text" name="qq" />
    科目:<input type="text" name="kemu"/>
    入学时间: <input type="text" name="startTime"/>
    学校: <input type="text" name="school"/>
    学号: <input type="text" name="xuehao"/>
    日报: <input type="text" name="ribao"/>
    心愿: <input type="text" name="xinyuan"/>
    师兄: <input type="text" name="shixiong">
    <input type="button" value="tijiao" id ="but">

</form>

<!--ajax 提交数据  #but 为 按钮id  #fm 为 form集合id -->
<script>
    $("#but").click(function () {
        $.ajax({
            type: "POST",   //提交的方法
            url:"/test/send", //提交的地址
            data:$('#fm').serialize(), // 序列化表单值
            async: false,
            error: function(request) {
                alert("Connection error"); //失败的话
            },
            success: function(data) {     // 成功 就将返回的数据显示出来  并返回到listAll.jsp
                alert(data);
                window.location.href="list"
            }
        });
    });
</script>

</body>

</html>
