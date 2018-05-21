<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}" />
    </json:property>
    <%--<json:property name="size" value="${size}"></json:property>--%>
    <json:property name="total" value="${total}"></json:property>
    <json:array name="data">
        <c:forEach items="${videoList}" var="video">
            <json:object>
                <json:property name="vid" value="${video.id}"></json:property>
                <json:property name="type" value="${video.type}"></json:property>
                <json:property name="title" value="${video.title}"></json:property>
                <%--<json:property name="cover" value="${video.cover}"></json:property>--%>
                <%--<json:property name="intro" value="${video.intro}"></json:property>--%>
                <%--<json:property name="mainBody" value="${video.mainBody}"></json:property>--%>
                <%--<json:property name="videoUrl" value="${video.videoUrl}"></json:property>--%>
                <json:property name="grade" value="${video.grade}"></json:property>
                <json:property name="subject" value="${video.subject}"></json:property>
                <json:property name="tid" value="${video.tid}"></json:property>
                <json:property name="teacherAvatar" value="${teacherMap[video.tid].teacherAvatar}"></json:property>
                <json:property name="teacherName" value="${teacherMap[video.tid].teacherName}"></json:property>
                <json:property name="collection" value="${video.collection}"></json:property>
                <json:property name="upvote" value="${video.upvote}"></json:property>
                <json:property name="status" value="${video.status}"></json:property>
                <%--<json:property name="createBy" value="${video.createBy}"></json:property>--%>
                <%--<json:property name="updateBy" value="${video.updateBy}"></json:property>--%>
                <json:property name="editTime" value="${video.updateAt}"></json:property>
                <%--<json:property name="createAt" value="${video.createAt}"></json:property>--%>
            </json:object>
        </c:forEach>
    </json:array>
</json:object>

