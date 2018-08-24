<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>


<head>
    <title><title:insertAttribute name="title"/></title>
    <tiles:insertAttribute name="header"/>
</head>

<body>
    <%--头部--%>
    <tiles:insertAttribute name="top" />
    <%--菜单--%>
    <tiles:insertAttribute name="nav"/>
    <%--内容--%>
    <tiles:insertAttribute name="body"/>
    <%--尾部--%>
    <tiles:insertAttribute name="footer"/>
</body>