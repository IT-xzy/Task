    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
        <!DOCTYPE html>
        <html>
        <head>
        <tiles:insertAttribute name="meta"/>
        <title><tiles:insertAttribute name="t10"/></title>
        <tiles:insertAttribute name="script"/>
        </head>
        <body>
        <div id="header">
        <tiles:insertAttribute name="header"/>
        </div>
        <div id="banner">
        <tiles:insertAttribute name="banner"/>
        </div class="main container">
        <%--<div id="body_css">--%>
        <div id="one_10">
        <tiles:insertAttribute name="one_10"/>
        </div>
        <div id="two_10">
        <tiles:insertAttribute name="two_10"/>
        </div>
        <div id="three_10">
        <tiles:insertAttribute name="three_10"/>
        </div>
        <div id="four_10">
        <tiles:insertAttribute name="four_10"/>
        </div>
        <%--<tiles:insertAttribute name="body_css"/>--%>
        <%--</div>--%>
        <div id="footer1">
        <tiles:insertAttribute name="footer1"/>
        </div>
        <div id="footer">
        <tiles:insertAttribute name="footer"/>
        </div>
        </body>
        </html>