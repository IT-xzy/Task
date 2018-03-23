
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>
<%@ taglib uri="/tags" prefix="date"%>
你好JSP
<%
    Date now = new Date();
    pageContext.setAttribute("now",now);
%>
完整日期: <fmt:formatDate value="${now}" pattern="G yyyy年MM月dd日 E"/><br>
完整时间: <fmt:formatDate value="${now}" pattern="a HH:mm:ss.S z"/><br>
常见格式: <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>
<br>
<%="hello jsp"%>

<c:set var="name" value="${'gareen'}" scope="request" />

<c:out value="${name}" /> <br>

<c:remove var="name" scope="request" /> <br>

<c:out value="${name}" /> <br>


${student.createTime}<br>


<body>
<c:choose>
    <c:when test="${islogin==true}">
        <p><a href="/u/logout">登出</a>${message}</p>
        <p><a href="/u/home">用户信息</a></p>
        <p><a href="/t11">可以直接查看的页面t11</a> </p>
        <p><a href="/u/t10">需要登陆的页面t10</a> </p>
    </c:when>
    <c:otherwise>
        <p><a href="/login">登陆</a>${message}</p>
        <P><a href="/phoneverify">注册</a> </P>
        <p><a href="/t11">可以直接查看的页面t11</a> </p>
        <p><a href="/u/t10">需要登陆的页面t10</a> </p>
    </c:otherwise>
</c:choose>

<%--&lt;%&ndash;<p><a href="/login">登陆</a>${message}</p>&ndash;%&gt;--%>

<%--<p><a href="/u/t10">需要登陆的页面t10</a> </p>--%>
<%--<p><a href="/t11">可以直接查看的页面t11</a> </p>--%>
<%--<p><a href="/u/home">用户信息</a></p>--%>
</body>


