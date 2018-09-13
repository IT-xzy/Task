<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>登录失败</title>
<head>
    <script type="text/javascript">
        function countDown(secs,surl){
            //alert(surl);
            var jumpTo = document.getElementById('jumpTo');
            jumpTo.innerHTML=secs;
            if(--secs>0){
                setTimeout(" countDown( "+secs+",'" + surl+ " ')",1000);
            }
            else
            {
                location.href=surl;
            }
        }
    </script>
</head>
<div align="center"><font color="red" size="6" >密码或者账号错误，登录失败</font></div>
<body><span id="jumpTo" >5</span>秒后自动跳转到登录页面...
<script type="text/javascript">
    countDown(5,'${pageContext.request.contextPath}/loginjsp/login.jsp');
</script>
</body>
</html>
