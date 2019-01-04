    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
        <!DOCTYPE html>
        <html>
        <head>
        <tiles:insertAttribute name="meta"/>
        <title><tiles:insertAttribute name="t11"/></title>
        <tiles:insertAttribute name="script"/>
        </head>
        <body>
        <div id="header">
        <tiles:insertAttribute name="header"/>
        </div>
        <div id="one_11">
        <tiles:insertAttribute name="one_11"/>
        </div>
        <div id="jobShow1">
        <tiles:insertAttribute name="jobShow1"/>
        </div>
        <div id="jobShow2">
        <tiles:insertAttribute name="jobShow2"/>
        </div>
        <div id="footer1">
        <tiles:insertAttribute name="footer1"/>
        </div>
        <div id="footer">
        <tiles:insertAttribute name="footer"/>
        </div>
        </body>
        </html>