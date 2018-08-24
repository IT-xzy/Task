<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/27
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>操作有误</title>
</head>

<script type="text/javascript">
    function countDown(secs) {
        document.getElementById("jump").innerHTML = secs;
        if (--secs > 0){
            setTimeout("countDown(" + secs + " )", 1000);
        }else{
            <%-- 填写跳转地址--%>
            location.href="${pageContext.request.contextPath}/logout";
        }
    }
</script>

<body style="overflow: auto;" onload="javascript:countDown(4);">
<div align="center"><font color="red" size="10" >操作有误</font></div>
<div align="center">......页面将在<span id="jump"></span>秒后自动跳转......
</div>
</body>
</html></html>
