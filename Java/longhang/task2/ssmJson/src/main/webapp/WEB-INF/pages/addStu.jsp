<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme() + "://"--%>
            <%--+ request.getServerName() + ":" + request.getServerPort()--%>
            <%--+ path + "/";--%>
<%--%>--%>
<html>
<title>添加用户</title>
</head>
<body>
<h1>添加用户</h1>
<form action="${pageContext.request.contextPath}/student"  method="post">
    姓名：<input type="text" name="name"><br>
    qq：<input type="text" name="qq"><br>
    愿言：<input type="text" name="wish"><br>
    修真类型：<input type="text" name="major"><br>
    创建时间：<input type="text" name="create_at"><br>
    跟新时间：<input type="text" name="update_at"><br>
    日报连接：<input type="text" name="dairylink"><br>
    <%--<input type="button" value="添加"--%>
           <%--onclick="addStu()">--%>
    <p id="buttons">
        <input  type="submit" tabindex="5" value="添加">
    </p>
</form>

<%--<script type="text/javascript">--%>
    <%--function addStu() {--%>
        <%--var form = document.forms[0];--%>
        <%--form.action = "${pageContext.request.contextPath}student/addStu";--%>
        <%--form.method = "post";--%>
        <%--form.submit();--%>
    <%--}--%>
<%--</script>--%>
</body>
</html>