<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/6/11
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<div>
    <%-- 头部 --%>
    <tiles:insertAttribute name="head" />
        <%-- 顶部--%>
    <tiles:insertAttribute name="top" />
        <%-- 中间 --%>
    <tiles:insertAttribute name="homeNav" />
        <%-- 更改部分 --%>
    <tiles:insertAttribute name="body" />
        <%-- 脚部 --%>
    <tiles:insertAttribute name="foot" />
</div>
