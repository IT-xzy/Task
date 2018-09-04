<%--suppress JSAnnotator --%>
<%--suppress ALL --%>
<%--suppress JSAnnotator --%>
<%--suppress ALL --%>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>

<script type="text/javascript">


    function check(d) {
        var usn = document.getElementById('userName').value;
        var psd = document.getElementById('psd').value;
        var password = document.getElementById('password').value;
        var tel = document.getElementById('telNum').value;
        var email = document.getElementById('email').value;
        var code = document.getElementById('code').value;
        if (usn.length < 3) {
            alert("用户名太短");
            d = 0
        } else if (psd.length < 6) {
            alert("最少输入6位密码");
            d = 0
        } else if (password.length == 0) {
            alert("再次输入密码");
            d = 0
        } else if (password.toString() != psd.toString()) {
            alert("两次密码不一致");
            d = 0
        } else if (tel.length != 11) {
            alert("请输入正确的手机号");
            d = 0
        } else if (email.indexOf("@") == -1) {
            alert("邮箱格式不正确");
            d = 0
        } else if (code.length != 6) {
            alert("验证码长度不正确");
            d = 0
        } else {
            d = 1
        }
        return d
    }

    function checkName(d) {
        var name = $('#userName').val();
        $.ajax({
            type: "post",
            url: '${pageContext.request.contextPath}/checkUser',
            data: "name=" + name,
            success: function (data) {
                d = data;
                if (data == 0) {
                    alert("用户名已存在");
                    return false;
                } else if (data == 1) {
                    return true;
                }
            }

        });
        return d
    }

    function email() {
        var email = $('#email').val();
        $.ajax({
            type: "post",
            url: '${pageContext.request.contextPath}/Code',
            data: "addr=" + email,
            success: function (data) {
                if (data == 1) {
                    alert("邮箱验证码发送成功");
                } else if (data == 0) {
                    alert("邮箱验证码发送失败");
                }else if (data == 2) {
                    alert("发送次数超限");
                }else if (data == 3) {
                    alert("操作过于频繁");
                }
            }

        });
    }

    function sms() {
        var telNum = $('#telNum').val();
        $.ajax({
            type: "post",
            url: '${pageContext.request.contextPath}/Code',
            data: "addr=" + telNum,
            success: function (data) {
                if (data == 1) {
                    alert("短信验证码发送成功");
                } else if (data == 0) {
                    alert("短信验证码发送失败");
                }else if (data == 2) {
                    alert("发送次数超限");
                }else if (data == 3) {
                    alert("操作过于频繁");
                }
            }

        });
    }

    function checkCode(d) {
        var code = $('#code').val();
        var telNum = $('#telNum').val();
        var email = $('#email').val();
        $.ajax({
            type: "post",
            url: '${pageContext.request.contextPath}/checkCode',
            data: "data=" + code + "," + telNum + "," + email,
            success: function (data) {
                d = data;
                if (data == 1) {
                    alert("验证码正确");
                } else if (data == 0) {
                    alert("验证码错误");
                }
            }
        });
        return d
    }

    function d() {
        var d = 0;
        d = checkName(d);
        d = check(d);
        d = checkCode(d)
        if (d == 0) {
            return false
        } else {
            return true
        }
    }


</script>

<div align="center">
    <form action="/register" method="post">
        <p>用户名：<input type="text" name="userName" id="userName" placeholder="请输入至少三位用户名">
        </p>
        <p>密码：<input type="password" id="psd" placeholder="请输入密码"></p>
        <p>再次输入密码：<input type="password" name="password" id="password" placeholder="再次输入密码"></p>
        <p>电话：<input type="text" name="telNum" id="telNum" placeholder="请输入电话号">
        </p>
        <p>邮箱：<input type="text" name="email" id="email" placeholder="请输入邮箱">
        </p>
        <p>验证码：<input type="text" name="code" id="code" placeholder="请输入验证码"></p>
        <button type="submit" onclick="return d()">注册</button>
    </form>
    <button type="button" onclick="sms()">发送短信验证码</button>
    <button type="button" onclick="email()">发送邮箱验证码</button>
    <button type="button" onclick="checkCode()">检测验证码</button>
</div>
</body>
</html>