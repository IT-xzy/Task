<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/11/14
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isErrorPage="true" %>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <!DOCTYPE html>
    <html lang="zh-CN">
    <head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:getAsString name="title" /></title>
    <%--home--%>
    <link rel="icon" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADEAAAAxCAMAAABEQrEuAAAAh1BMVEUAAAARhoYRhoYRhoYRhoYRhoYRhoYRhoYdjIwgjo4pkZEvlZU1l5c7m5tBnJ1NoqJNpKRZp6hbrKxlra1qs7NxsrN5u7uIvb6Iw8OUw8SgyMqgy8ym0tK12dm409XE2drE293E4eHQ3uDT4OLW4uTh8PDi6uzo7/Dw9fXw9/f2+fn8/f3///8dtfPzAAAAB3RSTlMAECBwgL/faEgB6QAAAO1JREFUSMftllsTwTAQhUNLpHEJDYK6hSLs//99OjWIoenuGzPO836TOTk7c5axZovj1Woy1mhzitoNFnGaIhYTifgnCCmohIFsRCUAXBD6RBRSf+K7iG6aUN9Y2fmwQyLGttDsA1RJJLbUejpAO59Ze4f6OGJgn9r0UL+7us/vT/5vB4j0Nr87vuYTSjAZr609XABPcN5ZnN92IEjIJQCFEMYBidA5AIVQW2/emfoE/XnIBCJzT1uF2quHco3c3YcBUbvtkxcDEtMGKq8yUN0fugzOaULjiMKMEbSOkvLXmxND0K8M+iVDv5bIugLLC3QU9WgdqQAAAABJRU5ErkJggg==">
    <link href="<c:url value='/static/css/bootstrap.min.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/css/dfghrgdffbdfb6base.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/ghjghjghjbnmyhj.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/Untitled-1base.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/Untitled-3.css'/>" rel="stylesheet"></link>
    <%--profession--%>
    <link href="<c:url value='/static/css/base.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/font.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/t11.css'/>" rel="stylesheet"></link>
    <script src="<c:url value='/static/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/js/bootstrap.min.js'/>"></script>
    </head>
    <body>
    <header id="header">
    <tiles:insertAttribute name="header"/>
    </header>
    <section id="menu">
    <tiles:insertAttribute name="menu"/>
    </section>
    <main id="main">
    <tiles:insertAttribute name="main"/>
    </main>
    <footer id="footer">
    <tiles:insertAttribute name="footer"/>
    </footer>
    </body>
    </html>
