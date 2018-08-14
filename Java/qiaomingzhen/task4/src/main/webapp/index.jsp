<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<html>
<body>

<div style="width:500px;margin:0px auto;text-align:center">
    <form>
        <input type="submit" value="学员" onclick="window.open('${pageContext.request.contextPath}/people')"><br/>
        <input type="submit" value="合作企业" onclick="window.open('${pageContext.request.contextPath}/company')"><br/>
        <input type="submit" value="修真类型" onclick="window.open('${pageContext.request.contextPath}/profession')">
    </form>

</div>

</body>
</html>
