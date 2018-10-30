
<%@ page contentType="text/html;charset=UTF-8" deferredSyntaxAllowedAsLiteral="true"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--后台返回的数据是${data}--%>
<%--<form action="/students" method="GET">--%>
    <%--要查询学员的id:<br>--%>
    <%--&lt;%&ndash;<input type="hidden" name="_method" value="DELETE" /><br>&ndash;%&gt;--%>
    <%--<input type="text" name="id" value="1">--%>
    <%--<br><br>--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>
<br><br>
<form action="/students"  method="GET">
    要查询学员的名字:<br>
    <input type="text" name="name"  value="苏正荣">
    <br><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
