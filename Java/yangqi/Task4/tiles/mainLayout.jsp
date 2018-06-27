<%--
  Created by IntelliJ IDEA.
  User: Yzzzt
  Date: 2018/6/11
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<head>
    <title><title:insertAttribute name="title"/></title>
    <tiles:insertAttribute name="header"/>
</head>
<body>
<%-- 头部 --%>
<tiles:insertAttribute name="top"/>
<%-- nav --%>
<tiles:insertAttribute name="nav"/>
<%-- 内容 --%>
<tiles:insertAttribute name="body"/>
<%-- 脚部 --%>
<tiles:insertAttribute name="foot"/>
</body>
