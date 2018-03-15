<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/2/1
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>
<table>
    <tr>
        <td>
            <tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td>
            <tiles:insertAttribute name="body" />
        </td>
    </tr>


    <tr>
        <td>
            <tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>

