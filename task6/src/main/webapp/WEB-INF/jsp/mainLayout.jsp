<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/10/21
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<div>

        <tiles:insertAttribute name="header"/>

        <tiles:insertAttribute name="body"/>

        <tiles:insertAttribute name="footer"/>

</div>
