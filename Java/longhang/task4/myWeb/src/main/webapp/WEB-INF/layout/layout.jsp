<%@ page language="java" contentType="text/html; charset=UTF-8"
                    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    <!DOCTYPE html>
    <html>
    <head>
    <tiles:insertAttribute name="meta" />
    <title><tiles:insertAttribute name="title" /></title>
    <%--<tiles:insertAttribute name="script" />--%>
    </head>
    <body>
    <div id="header">
    <tiles:insertAttribute name="header" />
    </div>
    <div id="body">
    <tiles:insertAttribute name="body" />
    </div>
    <div id="footer">
    <tiles:insertAttribute name="footer" />
    </div>
    </body>
    </html>