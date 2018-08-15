<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true" %>

<html>
<head>
    <title>error page</title>
</head>
<body>
<h1 align="center"><%= exception.getMessage()%></h1>
<h2 align="center"><a  href="javascript:history.go(-1); " >返回</a></h2>

</body>
</html>