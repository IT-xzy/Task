<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2018/5/18
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<head>
    <title:insertAttribute name="head" />

    <title><tiles:insertAttribute name="title" /></title>
</head>
<table>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="top" />
        </td>
    </tr>
    <tr>
        <td>
            <tiles:insertAttribute name="menu" />
        </td>
        <td>
            <tiles:insertAttribute name="body" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>