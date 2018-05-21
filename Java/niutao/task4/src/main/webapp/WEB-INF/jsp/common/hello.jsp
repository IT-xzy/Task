<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2018/1/19
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>
<%@ taglib uri="/tags" prefix="date"%>
你好JSP
<br>
<%
    Date now = new Date();
    pageContext.setAttribute("now",now);
%>
<%=new Date().toLocaleString()%><br>
完整日期: <fmt:formatDate value="${now}" pattern="G yyyy年MM月dd日 E"/><br>
完整时间: <fmt:formatDate value="${now}" pattern="a HH:mm:ss.S z"/><br>
常见格式: <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>
<br>
<%="hello jsp"%>

<c:set var="name" value="${'gareen'}" scope="request" />

<c:out value="${name}" /> <br>

<c:remove var="name" scope="request" /> <br>

<c:out value="${name}" /> <br>

<c:set var="date" value="${'125487569242'}"/>


<date:date value ="${date} "/>

${student.createTime}


