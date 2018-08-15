<%@ tag import="java.util.Date" %>
<%@ tag import="java.text.SimpleDateFormat" %>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ attribute name="format" required="true" rtexprvalue="true" %>
<%
    Date dNow = new Date( );
    SimpleDateFormat ft = new SimpleDateFormat (format);
    out.print( "<h2>" + ft.format(dNow) + "</h2>");
%>