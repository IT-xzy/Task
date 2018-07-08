<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<head>
    <%-- 页面 title --%>
    <title><title:insertAttribute name="title"/></title>
    <tiles:insertAttribute name="head"/>
</head>
<body>
<%-- 头部 --%>
<tiles:insertAttribute name="top"/>
<%-- nav --%>
<tiles:insertAttribute name="nav"/>
<%-- 内容 --%>
<tiles:insertAttribute name="body"/>
<%-- 脚部 --%>
<tiles:insertAttribute name="footer"/>
</body>

