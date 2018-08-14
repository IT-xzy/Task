<%--<%@page pageEncoding="utf-8"%>--%>

<%--<html>--%>
<%--<body>--%>
<%--<h2>Hello World!</h2>--%>
<%--<form action="${pageContext.request.contextPath}/main" >--%>
    <%--&lt;%&ndash;<input type="hidden" name="pageId" value="1">&ndash;%&gt;--%>
    <%--<input type="submit" value="登录">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="login">
    <tiles:putAttribute name="title" value="这是一个有Apache Tiles构建的页面布局." />
</tiles:insertDefinition>
<html>
<body>

</body>
</html>
