<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>手机验证</title>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<h1 align="center">手机验证</h1>
<br>
<br>


<form action="" class="form-horizontal" role="form" method="post" id="form">
<table align="center" border="1" width="60%">
    <tr>
        <th align="center" colspan="3">修真院学员手机验证</th>
    </tr>
    <tr>
        <td>手机号</td>
        <td><input id="phone" name="phone" value="" type="text" placeholder="请输入手机号"></td>
        <td><button id="abc" type="button" >发送验证码</button></td>
    </tr>
    <tr>
        <td>验证码</td>
        <td><input id="code" name="code" value="" type="text" placeholder="请输入验证码"></td>
        <td><button id="abcd"type="button" >验证</button></td>
    </tr>
</table>
<br><br><br><br>
<div align="center">
    <a href="${pageContext.request.contextPath}/home">返回主页</a>
</div>

</form>


<script>
    var s = 0;
    $("#abc").click(function () {
        var phone = $("#phone").val();
        console.log("开始")
        if (s === 0) {
            $.ajax({
                url: "${pageContext.request.contextPath}/u/phone",
                data: {
                    phone: phone
                },
                type: "post",
                success: function (data) {
                    if (data.status === 0) {
                        console.log(data);

                        <%--window.location.href = "${pageContext.request.contextPath}/error";--%>
                    }

                    alert(data.message);
                },
                error:function (data) {
                    console.log(data);
                    alert(data.message);
                }
            })
            resetTime(60);
        }
    })
    $("#abcd").click(function () {
        var code=$("#code").val();
        var phone = $("#phone").val();
        $.ajax({
            url: "${pageContext.request.contextPath}/u/vphone",
            data: {
                code:code,
                phone: phone
            },
            type: "post",
            success: function (data) {
                console.log(data);
                if (data.status === 0) {
                    alert(data.message);
                    window.location.href = "${pageContext.request.contextPath}/u/user";
                }
            },
            error:function (data) {
                alert(data.message);
                console.log(data);
            }
        })


    })


    function resetTime(time) {
        var timer = null;
        var t = time;
        var m = 0;
        s = 0;
        m = Math.floor(t / 60 % 60);
        m < 10 && (m = '0' + m);
        s = Math.floor(t % 60);

        function countDown() {
            s--;
            s < 10 && (s = '0' + s);
            if (s.length >= 3) {
                s = 59;
                m = "0" + (Number(m) - 1);
            }
            if (m.length >= 3) {
                m = '00';
                s = '00';
                clearInterval(timer);
            }
            $("#abc").text(s + "秒");
            if(s==0){
                clearInterval(timer);
                $("#abc").text("发送验证码")
            }
        }
        timer = setInterval(countDown, 1000);
    }
</script>
<script src="/js/jquery.min.js"></script>
</body>
</html>