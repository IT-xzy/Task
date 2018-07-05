<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2018/5/1
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提示页面</title>
    <meta http-equiv="refresh" content='5; url=${pageContext.request.contextPath }/'>
</head>
<body>
<h1 style="text-align:center" ><font color="red">${message}</font></h1>
<h1 style="text-align:center" >该页面将在<span id= "time" style="color: red"> 5 </span>秒后自动跳转</h1>

<script language="javascript">
    var times=6;
    clock();
    function clock()
    {
        window.setTimeout('clock()',1000);
        times=times-1;
        time.innerHTML =times;
    }
</script>
</body>
</html>
