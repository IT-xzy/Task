<%--通知浏览器以utf-8解码--%>
<%@page contentType="text/html; charset=UTF-8"

        pageEncoding="UTF-8" import="java.util.*" %>
<%--如果jsp中出现了中文则以utf-8解码，引入java.util包，导入多个包可以用逗号隔开--%>
你好，欢迎登陆！
<%--显示内容--%>
<br/>
<%="Hello,welcome login"%>
<br/>
<%out.print("Helle,welcome login");%>
<%--注意这里的;不能漏--%>
<br/>
<%=new Date().toLocaleString()%>
<%--输出当前时间，相当于servlet中使用response.getWriter()进行输出--%>
<br/>
<%
    List<String> words=new ArrayList<String>();
    words.add("淡然销魂泪满觞,");
    words.add("定须谨记难相忘.");
    words.add("最爱放歌倚纵酒,");
    words.add("帅哥如吾自惆怅.");
%>
<table width="160px" align="left" border="1" cellspacing="1">
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
<br/>
<br/>
<%--<%@include file="footer.jsp" %>--%>
<%--include指令--%>

<jsp:include page="WEB-INF/views/footer.jsp" >
    <jsp:param  name="year" value="2017" />
</jsp:include>

<%--include动作，两种作用一样--%>