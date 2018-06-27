<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1"  >
    <tr>
        <td colspan="1"><tiles:insertAttribute name="header"/></td>
    </tr>
    <tr>
        <td><tiles:insertAttribute name="body"/></td>
    </tr>
    <tr>
        <td colspan="1"><tiles:insertAttribute name="footer"/></td>
    </tr>
</table>
