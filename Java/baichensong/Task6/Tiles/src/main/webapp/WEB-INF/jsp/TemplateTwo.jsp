<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Home2</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/confTwo/t11.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/confTwo/base.css" rel="stylesheet" type="text/css">
    <!-- home1  的css-->

</head>
<body>

<header>
    <tiles:insertAttribute name="headerTwo"/>
</header>

<tiles:insertAttribute name="bodytwo"/>

<footer class="footer">
    <tiles:insertAttribute name="footerTwo"/>
</footer>
</body>
</html>
