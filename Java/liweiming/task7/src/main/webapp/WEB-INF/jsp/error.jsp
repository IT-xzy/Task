<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\7\5 0005
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Show Error Page</title>
    <meta http-equiv="refresh" content='3; url=${pageContext.request.contextPath }/'>

</head>
<body>
<h1>Opps...</h1>
<table width="100%" border="1">
    <tr valign="top">
        <td width="40%"><b>Error:</b></td>
        <td>${message}</td>
    </tr>
</table>

<h1 style="text-align:center" >该页面将在<span id= "time" style="color: red"> 3 </span>秒后自动跳转</h1>

<script language="javascript">
    var times=4;
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