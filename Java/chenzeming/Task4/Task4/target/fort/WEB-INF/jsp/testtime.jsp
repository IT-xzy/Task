<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/24
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="utils" uri="/WEB-INF/taglib/time.tld" %>
<html>
<head>
    <title>time</title>
</head>
<body>
${utils:dateTag(time,"yyyy-MM-dd HH:mm:ss")}
</body>
</html>
