    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
        <%@ page contentType="text/html; charset=utf-8"%>
        <!doctype html>
        <html>
<head>

        <div id="header">
                <t:insertAttribute name="header"/>
        </div>
</head>
        <body>

        <div id="body">
        <t:insertAttribute name="body"/>
        </div>
        </body>
<footer>
        <div id="footer">
                <t:insertAttribute name="footer"/>
        </div>
</footer>
        </html>