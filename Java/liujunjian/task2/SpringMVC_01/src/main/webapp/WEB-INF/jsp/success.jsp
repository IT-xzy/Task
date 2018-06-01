<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>
<tr>登录成功!</tr><br>
<tr>3秒后自动跳转到首页...</tr>
<%--定义name让表单自动提交，定义id让表单信息隐藏，利用了script--%>
<form method="GET" action="${pageContext.request.contextPath}/user/page" name="home" id="success">
    <tr>
        <td><input type="hidden" name="page" value="1"></td>
        <td><input type="submit" value="首页"></td>
    </tr>
</form>
<script>
    function sub() {
        document.home.submit();
    }

    document.getElementById('success').style.display = 'none';
    setTimeout(sub, 3000);//以毫秒为单位的.1000代表一秒钟.根据你需要修改这个时间.
</script>
</body>
</html>