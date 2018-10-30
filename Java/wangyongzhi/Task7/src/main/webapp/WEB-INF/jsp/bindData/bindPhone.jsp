<!--注意isELIgnored是选择EL表达式是否输出-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<html>
<head>
    <title>绑定/修改手机号</title>
    <script type="text/javascript">
        /**
         * 刷新验证码
         */
        function reloadCode() {
            var time = new Date().getTime();
            document.getElementById("imgCode").src = "<%=request.getContextPath() %>/verifyCode?d=" + time;
        }

        function checkLoginNoNull() {
            if (document.getElementById("verifycode").value == "") {
                alert("验证码不能为空！请重新输入！");
            }else{
                document.getElementById("form1").submit();
            }
        }
    </script>
</head>
<body>
<h2 align="center">绑定/修改手机号</h2>
<form action="${pageContext.request.contextPath}/u/bindPhone" id="form1" method="post" align="center">
    <table align="center" width="600">
        <tr>
            <td align="right"><font color="red">*</font><strong>手机号码：</strong></td>
            <td align="left"><input type="text" name="telephone" style="background-color: deepskyblue">
                ${map.warning}</td>
        </tr>
        <tr>
            <td align="right"><img src="<%=request.getContextPath()%>/verifyCode" id="imgCode"
                                   alt="看不清楚？请点击刷新验证码" onclick="javascript:reloadCode();"
                                   class="yzm-img"/></td>
            <td align="left"><input type="text" name="imageCode" id="verifycode" style="background-color: deepskyblue">
                ${map.error}</td>
        </tr>
    </table>
    <div align="center"><input type="button" value="发送验证码" onclick="javascript:checkLoginNoNull();"></div>

</form>
<div align="center"><button type="button"><a href="${pageContext.request.contextPath}/u/showInfo">
    放弃更改</a></button></div>
</body>
</html>
