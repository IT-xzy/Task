<%@ tag import="java.util.Date" %>
<%@ tag import="java.text.SimpleDateFormat" %>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ attribute name="format" required="true" rtexprvalue="true" %>
<%
    long time=System.currentTimeMillis();
    Date d = new Date(time);
    SimpleDateFormat s=new SimpleDateFormat(format);
    String s1=s.format(d);
%>
<%=s1%>