<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags" prefix="date" %>
<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>用户信息</title>
</head>
<%request.setCharacterEncoding("utf-8");%>

<style>
    table, table td, table th {
        border: 1px solid yellowgreen;
        border-collapse: collapse;
        text-align: center;
    }
</style>
<%--sprict--%>
<script src="https://cdn.bootcss.com/jquery/3.3.0/jquery.min.js"></script>
<script type="text/javascript">
    /*根据返回值弹出不同信息*/
    function sendBth(id) {
        var url = "${pageContext.request.contextPath}/rest/user/" + id;
        /*得到href的值*/
        $.ajax({
            url: url,
            type: 'DELETE',
            success: function (result) {
                //判断result结果
                if (result) {
                    alert("id:" + id + "删除成功，即将返回页面")
                    window.location.reload();
                } else {
                    alert("id: " + id + "删除失败")
                }
            }
        });
    }
</script>
<body>

<form action="${pageContext.request.contextPath}/rest/user" method="POST" accept-charset="UTF-8">
    <input type="hidden" name="_method" value="PUT"/>
    <fieldset>
        <legend>新增学生</legend>
        <table width="100%" >
            <tr>
                <td>名字</td>
                <td>QQ</td>
                <td>修真类型</td>
                <td>入学时间</td>
                <td>毕业学校</td>
                <td>学院学号</td>
                <td>日报连接</td>
                <td>愿望</td>
                <td>线上师兄</td>
                <td>创建时间</td>
                <td>更新时间</td>
                <td>操作</td>
            </tr>
            <tr>
                <td><input type="text" style="width: 50px;" name="name"></td>
                <td><input type="text" style="width: 50px;" name="qq"></td>
                <td><input type="text" style="width: 50px;" name="learning_type"></td>
                <td><input type="text" style="width: 70px" name="entrance_time"></td>
                <td><input type="text" style="width: 70px;" name="school"></td>
                <td><input type="text" style="width: 50px;" name="online_id"></td>
                <td><input type="text" name="daily_link"></td>
                <td><input type="text" name="wish"></td>
                <td><input type="text" style="width: 65px;" name="tutor"></td>
                <td><input type="text" style="width: 80px;" name="create_at"></td>
                <td><input type="text" style="width: 80px;" name="update_at"></td>
                <td>
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </fieldset>
</form>

<%--查询--%>
<form action="${pageContext.request.contextPath}/rest/" method="POST">
    <fieldset>
        <legend>查询学生</legend>
        <table width="100%" border=1>
            <tr>
                <td>根据名字查询:<label>
                    <input name="name">
                </label></td>
                <td>根据学习类型查询：
                    <label><input name="learning_type" ></label>
                </td>
                <td>根据学院学号查询：
                    <label><input name="online_id"></label>
                </td>
                <td><input type="submit" value="查询"/></td>
            </tr>
        </table>
    </fieldset>
</form>
<br>

<table border="1" width="100%" >
    <tbody>
    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>QQ</td>
        <td>修真类型</td>
        <td>入学时间</td>
        <td>毕业院校</td>
        <td>学院学号</td>
        <td>日报</td>
        <td>立愿</td>
        <td>辅导师兄</td>
        <td>创建时间</td>
        <td>更新时间</td>
    </tr>


        <c:forEach items="${items}" var="user">
    <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.qq}</td>
            <td>${user.learning_type}</td>
            <td><date:date value ="${user.entrance_time}"/></td>
            <td>${user.school}</td>
            <td>${user.online_id}</td>
            <td>${user.daily_link}</td>
            <td>${user.wish}</td>
            <td>${user.tutor}</td>
            <td><date:date value ="${user.create_at} "/></td>
            <td><date:date value ="${user.update_at} "/></td>
        </c:forEach>
    </tr>
    </tbody>
</table>



<fieldset>
    <legend>学生信息</legend>
    <table width="100%" border=1>
        <tr>
            <td>id</td>
            <td>名字</td>
            <td>QQ</td>
            <td>修真类型</td>
            <td>入学时间</td>
            <td>毕业学校</td>
            <td>学院学号</td>
            <td>日报连接</td>
            <td>愿望</td>
            <td>线上师兄</td>
            <td>创建时间</td>
            <td>更新时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemsList}" var="items">
            <tr>
                <td>${items.id}</td>
                <td>${items.name}</td>
                <td>${items.qq}</td>
                <td>${items.learning_type}</td>
                <td><date:date value="${items.entrance_time}"/></td>
                <td>${items.school}</td>
                <td>${items.online_id}</td>
                <td>${items.daily_link}</td>
                <td>${items.wish}</td>
                <td>${items.tutor}</td>
                <td><date:date value="${items.create_at}"/></td>
                <td><date:date value="${items.update_at}"/></td>
                <td><a href="${items.id}">修改</a>
                    <a href="" onclick="sendBth(${items.id})">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</fieldset>
</body>
</html>