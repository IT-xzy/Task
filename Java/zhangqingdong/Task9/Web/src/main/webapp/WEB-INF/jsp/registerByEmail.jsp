<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <script>

    </script>
    <style>
        .center {
            position: fixed;
            top: 50%;
            left: 50%;
            width:50%;
            height: 50%;
            -webkit-transform: translateX(-50%) translateY(-50%);
        }
        input {
            padding :10px 20px;
            font-size:20px;
        }
        .button{
            border: solid 1px blue ;
            background-color :white;
            color:green;
            padding :10px 20px;
            font-size:20px;
        }
    </style>
    <script src="${ctx}/static/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btn").click(function lick(o) {
                var obj = {};
                obj['email'] = $("#email").val();
                $.ajax({
                    type:"POST",
                    url:"${ctx}/email/code",
                    dataType:"json",
                    contentType:"application/json",
                    data:JSON.stringify(obj),
                    success:function(result){
                        alert("验证码发送成功!");
                        $("#code").val(result);
                        var count = 60;
                        var countdown = setInterval(CountDown, 1000);
                        function CountDown() {
                            $("#btn").attr("disabled", true);
                            $("#btn").val("在" + count + "秒后可以重新发送");
                            if (count === 0) {
                                $("#btn").val("重新发送验证码").removeAttr("disabled");
                                clearInterval(countdown);
                            }
                            count--;
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<div class="center">
    <form style="text-align:center;" action="${ctx}/email/user" method="post">
        <input name="username" type="text" placeholder="账户名" required><br><br>
        <input name="password" type="password" placeholder="密码" required><br><br>
        <input name="confirmPwd" type="password" placeholder="确认密码" required><br><br>
        <input name="email" id="email" type="text" placeholder="邮件地址" required><br><br>
        <input name="userCode" type="text" placeholder="验证码"><br><br>
        <input name="code" id="code" type="text" value="" hidden>
        <%-- <input class="button" type="submit" value="发送验证码">--%>
        <input  id="btn" class="button" type="button" value="发送验证码">
        <%--<button class="botton">发送验证码</button>--%>&nbsp;&nbsp;&nbsp;&nbsp;
        <input class="button" type="submit" value="注册">
    </form>
    <%--        <form style="text-align:center;" action="${ctx}/sms/code" method="post" target="nm_iframe">
                <input name="userCode" type="text" placeholder="验证码"><br><br>
                <input class="button" type="submit" value="发送验证码">
            </form>
            <iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>--%>
</div>
</body>
</html>