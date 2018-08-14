<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>请登录</title>
<head>
    <script type="text/javascript">
        function countDown(secs,surl){
            //alert(surl);
            var jumpTo = document.getElementById('jumpTo');
            jumpTo.innerHTML=secs;
            if(--secs>0){
                setTimeout("countDown("+secs+",'"+surl+"')",1000);
            }
            else
            {
                location.href=surl;
            }
        }
    </script>
</head>
<body>您还未登录，请登录后访问，<span id="jumpTo" >3</span>秒后自动跳转到登录页面...
<script type="text/javascript">
    countDown(3,'${pageContext.request.contextPath}/login/login.jsp');
</script>
</body>
</html>
