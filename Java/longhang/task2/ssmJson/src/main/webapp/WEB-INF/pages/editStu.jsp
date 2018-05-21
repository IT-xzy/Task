<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme() + "://"--%>
            <%--+ request.getServerName() + ":" + request.getServerPort()--%>
            <%--+ path + "/";--%>
<%--%>--%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>编辑用户</title>

    <%--<script type="text/javascript">--%>
    <%--function updateStu() {--%
    <%--var form = document.forms[0];--%>
    <%--form.action = "${pageContext.request.contextPath}student/updateStu";--%>
    <%--form.method = "post";--%>
    <%--form.submit();--%>
    <%--}--%>
    <%--</script>--%>

</head>
<body>
<h1>用户信息</h1>

    <form action="${pageContext.request.contextPath}/student" method="post">
        <input type="hidden" name="_method" value="PUT"/><br>
        id：<input type="text" name="id" value="${student.id}"/><br>
        姓名：<input type="text" name="name" value="${student.name}" /><br>
        QQ：<input type="text" name="qq" value="${student.qq}"/><br>
        愿言：<input type="text" name="wish" value="${student.wish}" /><br>
        修真类型：<input type="text" name="major" value="${student.major}" /><br>
        创建时间：<input type="text" name="create_at" value="${student.create_at}"/><br>
        修改时间：<input type="text" name="update_at" value="${student.update_at}"/><br>
        日报连接：<input type="text" name="dairylink" value="${student.dairylink}"/><br>
        <input  type="submit"  value="更改">

</form>
</body>

</html>