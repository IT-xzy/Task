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
    <title>用户</title>

    <%--<script type="text/javascript">--%>
    <%--function updateStu() {--%>
    <%--var form = document.forms[0];--%>
    <%--form.action = "${pageContext.request.contextPath}student/updateStu";--%>
    <%--form.method = "post";--%>
    <%--form.submit();--%>
    <%--}--%>
    <%--</script>--%>

</head>
<body>
<h1>用户信息</h1>



<tr>
    <td>id</td>
    <td>姓名</td>
    <td>qq</td>
    <td>愿言</td>
    <td>修真类型</td>
    <td>创建时间</td>
    <td>修改时间</td>
    <td>日报连接</td>
</tr>
<tr>

    <td>${student.id}</td>
    <td>${student.name }</td>
    <td>${student.qq }</td>
    <td>${student.wish }</td>
    <td>${student.major}</td>
    <td>${student.create_at}</td>
    <td>${student.update_at }</td>
    <td>${student.dairylink }</td>

    <%--<form action="${pageContext.request.contextPath}/lh/studentInfo"  >--%>
        <%--<p id="buttons"><input  type="submit"  value="返回">--%>
        <%--</p>--%>
    <%--</form>--%>
    <%--<form action="${pageContext.request.contextPath}/lh/tostudent/${student.id}" >--%>

        <%--<p id="button"><input  type="submit"  value="编辑">--%>
        <%--</p>--%>
    <%--</form>--%>

</tr>




</body>

</html>