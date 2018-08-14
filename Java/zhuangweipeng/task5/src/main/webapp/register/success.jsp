<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>注册成功</title>
<head>
    <script type="text/javascript">
        function countDown(secs, surl) {
            var jumpTo = document.getElementById('jumpTo');
            jumpTo.innerHTML = secs;
            if (--secs > 0) {
                setTimeout("countDown(" + secs + ",'" + surl + "')", 1000);
            }
            else {
                location.href = surl;
            }
        }
    </script>
</head>
<body>注册成功，<span id="jumpTo">3</span>秒后自动跳转到登录页面...
<script type="text/javascript">
    countDown(3, '${pageContext.request.contextPath}/login/login.jsp');
</script>
</body>
</html>
