<%--
  Created by IntelliJ IDEA.
  User: CH0918
  Date: 2018/7/19
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>登录成功</title>
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
<body>登录成功<span id="jumpTo" >3</span>秒后自动跳转到首页...
<script type="text/javascript">
    countDown(3,'${pageContext.request.contextPath}/index');
</script>
</body>
</html>
