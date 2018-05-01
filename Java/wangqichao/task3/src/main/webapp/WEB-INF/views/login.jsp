<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/4/8
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8"

        pageEncoding="UTF-8" import="java.util.*" %>
<head>
    <title>牛刀小试</title>
</head>

<br/>
<%--如果jsp中出现了中文则以utf-8解码，引入java.util包，导入多个包可以用逗号隔开--%>
<p style="text-align:center">少侠，欢迎登陆！<p/>
<%--显示内容--%>
<br/>
<br/>
<p style="text-align:center"><%="Hello,welcome login"%>
    <p/>
<br/>
<br/>
<br/>
<%
    List<String> words=new ArrayList<String>();
    words.add("飞雪连天射白鹿");
    words.add("笑书神侠倚碧鸳");

%>

<table width="160px" align="center" border="1" cellspacing="1">
    <%--<table>代表表格</table>--%>
    <%for (String word:words){%>
    <%--中间需要插入html标签，所以需要使用<%%>框起来--%>
    <tr>
        <%--<tr>代表表格中的一行</tr>--%>
        <td><%=word%></td>
        <%--<td>代表表格中的一列</td>，'tr'与'td'交成一个单元格--%>
    </tr>
    <%--<table>...</table>之间有多少个<tr>，就有多少行，<tr>...</tr>之间有多少个<td>，就有多少列--%>
    <%}%>
</table>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<%--<%@include file="footer.jsp" %>--%>
<%--include指令--%>
<p style="text-align:center"><a href="${pageContext.request.contextPath}/task2/list">查看百晓生排行榜</a><p/>
<%--跳转到list.jsp--%>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<p style="text-align:center">
<%=new Date().toLocaleString()%>
    <p/>
<%--输出当前时间，相当于servlet中使用response.getWriter()进行输出--%>
<jsp:include page="footer.jsp" >
    <jsp:param  name="year" value="2018" />
</jsp:include>

<%--include动作，两种作用一样--%>
