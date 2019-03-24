<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ page session="false" %>
<div>
    <t:insertAttribute name="header"/>
    <t:insertAttribute name="body"/>
    <t:insertAttribute name="footer"/>
</div>
