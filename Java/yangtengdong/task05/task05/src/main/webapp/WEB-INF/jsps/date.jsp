<%@ taglib prefix="ltd" uri="DateTags" %>

<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>时间转换类型</title>
</head>
<body>
<br><br>
<p>直接输出Long型和Date型</p>
${time1}<br>
${time2}<br>
<h2>通过工具类转化</h2>
${time4}<br>
${time5}<br>
${time6}<br>
${time8}<br>
${time9}<br>
<h2>通过自定义标签转化</h2>
<p>Long型转化为Date型</p>
<ltd:date value="${time1}"/><br>
<p>Date型转化为String型; fmt标签中只接受Date型 </p>
<fmt:formatDate value="${time2}" type="date"/><br>
<fmt:formatDate value="${time2}" type="time"/><br>
<fmt:formatDate value="${time9}" type="both"/><br>
</body>
</html>
