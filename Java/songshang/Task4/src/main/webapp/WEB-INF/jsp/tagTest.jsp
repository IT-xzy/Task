<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://dwk.com.fml" prefix="my" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
根据您刚才输入的Long值和显示类型，此Long值对应的时间为：
<my:parseLong value="${value}" pattern="${pattern}"/>
</body>
</html>
