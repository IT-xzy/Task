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
    <title>修真院</title>
</head>

<br/>
<%--如果jsp中出现了中文则以utf-8解码，引入java.util包，导入多个包可以用逗号隔开--%>
<p style="text-align:center">少侠，欢迎登陆！<p/>
<%--显示内容--%>
<br/>

<p style="text-align:center"><%="Hello,welcome login"%>
    <p/>
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
<form method="post" action="${pageContext.request.contextPath}/login">
    <table align="center" border="1" cellspacing="0" >
        <tr>
            <th>用户名</th>
            <td><input type="text" placeholder="请输入用户名" size="20" name="username"></td>
        </tr>
        <tr>
            <th>密码</th>
            <td><input type="password" placeholder="请输入密码" size="20" name="password"></td>
        </tr>
    </table>
<%--判断输入的用户名和密码是否正确--%>
    <%--<input type="hidden" value="PUT" name="_method">--%>
 <p style="text-align: center">  <input type="submit"  value="登陆修真院主页"/></p></form>
<%--注意这里因为要携带数据过去所以不使用超链接的形式--%>
<%--<p style="text-align:center"><a href="${pageContext.request.contextPath}/homepage">登陆修真院主页</a><p/>--%>
<%--跳转到controller层的register--%>
<form method="get" action="${pageContext.request.contextPath}/register">
<p style="text-align:center"><input type="submit" value="注册修真院账号"/><p/></form>
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
<jsp:include page="/WEB-INF/views/footer.jsp" >
    <jsp:param  name="year" value="2018" />
</jsp:include>

<%--include动作，两种作用一样--%>
