<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://code.jquery.com/jquery-3.2.1.slim.min.js">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Title</title>
</head>
<%-- layout.jsp就是主布局页面，可以把公用的js、css的引用写在这个页面，子页面就不用再重复引入了。--%>
<body>
<div id="header">
    <tiles:insertAttribute name="header" />
</div>
<div id="body">
    <tiles:insertAttribute name="body"/>
</div>
<%--<div id="main">
    <tiles:insertAttribute name="main" />
</div>
<div id="recommend">
    <tiles:insertAttribute name="recommend" />
</div>
<div id="profession">
    <tiles:insertAttribute name="profession"/>
</div>
<div id="login">
    <tiles:insertAttribute name="login" />
</div>
<div id="register">
    <tiles:insertAttribute name="register" />
</div>--%>
<div id="footer">
    <tiles:insertAttribute name="footer" />
</div>

</body>
</html>
