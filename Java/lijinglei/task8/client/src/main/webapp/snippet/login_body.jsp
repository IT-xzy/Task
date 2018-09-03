<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>

<script type="text/javascript">
    function transToQn() {
        $.ajax({
            type: "post",
            url: '${pageContext.request.contextPath}/transToQn',
            success: function (data) {
                if (data == 1) {
                    alert("腾讯到七牛迁移成功");
                } else if (data == 0) {
                    alert("腾讯到七牛迁移失败");
                }
            }
        });
    }


    function transToCos() {
        $.ajax({
            type: "post",
            url: '${pageContext.request.contextPath}/transToCos',
            success: function (data) {
                if (data == 1) {
                    alert("七牛到腾讯迁移成功");
                } else if (data == 0) {
                    alert("七牛到腾讯迁移失败");
                }
            }
        });
    }
</script>


<div align="center">
    <form action="/login" method="post">
        <p>用户名：<input type="text" name="userName"></p>
        <p>密码：<input type="password" name="password"></p>
        <input type="submit" value="登录">
    </form>


    <button type="submit" onclick="transToQn()">从腾讯到七牛云</button>
    <button type="submit" onclick="transToCos()">从七牛到腾讯云</button>

</div>
</body>
</html>