<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>注册失败</title>
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
<div align="center"><font color="red" size="6" >注册用户名不允许为空或者相同</font></div>
<body><span id="jumpTo" >3</span>秒后自动跳转到注册页面...
<script type="text/javascript">
    countDown(3,'${pageContext.request.contextPath}/register/register.jsp');
</script>
</body>
</html>
