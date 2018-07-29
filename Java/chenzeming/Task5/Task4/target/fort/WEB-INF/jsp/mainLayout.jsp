<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/21
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<div>

        <tr>
            <td><tiles:insertAttribute name="header"/></td>
        </tr>
        <tr>
            <td><tiles:insertAttribute name="body"/></td>
        </tr>
        <tr>
            <td><tiles:insertAttribute name="footer"/></td>
        </tr>
</div>
