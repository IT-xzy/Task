<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/tags" prefix="date" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>查询个人信息</title>
</head>

<style>
    table, table td, table th {
        border: 1px solid;
        border-collapse: collapse;
        text-align: center;
    }
</style>
<%--sprict--%>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
    /*根据返回值弹出不同信息*/
    function sendBth(id) {
        var url = '${pageContext.request.contextPath}/rest/' + id;
        /*得到href的值*/
        $.ajax({
            url: url, /*url也可以是json之类的文件等等*/
            type: 'DELETE', /*DELETE,POST*/
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

<form action="${pageContext.request.contextPath}/rest/a" method="POST">
    <input type="hidden" name="_method" value="PUT"/>--%>
    <fieldset>
        <legend>新增学生</legend>
        <table width="100%" border=1>
            <tr>
                <td>名字</td>
                <td>QQ</td>
                <td>修真类型</td>
                <td>预计入学时间</td>
                <td>毕业学校</td>
                <td>学院学号</td>
                <td>日报连接</td>
                <td>愿望</td>
                <td>线上师兄</td>
                <td>从哪了解到</td>
                <td>操作</td>
            </tr>
            <tr>
                <td><input type="text" style="width: 80px;" name="name"></td>
                <td><input type="text" style="width: 100px;" name="QQ"></td>
                <td><input type="text" style="width: 100px;" name="major"></td>
                <td><input type="text" name="startTime"></td>
                <td><input type="text" style="width: 120px;" name="school"></td>
                <td><input type="text" style="width: 65px;" name="student_Id"></td>
                <td><input type="text" name="daily_cone"></td>
                <td><input type="text" name="desire"></td>
                <td><input type="text" style="width: 65px;" name="bre"></td>
                <td><input type="text" style="width: 80px;" name="know_from"></td>
                <td>
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<%--这里是查询全部↓--%>
<form action="${pageContext.request.contextPath}/rest/" method="GET">
    <fieldset>
        <legend>查询学生</legend>
        <table width="100%" border=1>
            <tr>
                <td>根据名字查询:<label>
                    <input name="name">
                </label></td>
                <!-- 根据姓名查询：<input name="name">-->
                <td><input type="submit" value="查询"/></td>
            </tr>
        </table>
    </fieldset>
</form>
<fieldset>
    <legend>学生信息</legend>
    <table width="100%" border=1>
        <tr>
            <td>id</td>
            <td>名字</td>
            <td>QQ</td>
            <td>修真类型</td>
            <td>预计入学时间</td>
            <td>毕业学校</td>
            <td>学院学号</td>
            <td>日报连接</td>
            <td>愿望</td>
            <td>线上师兄</td>
            <td>从哪了解到</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemsList}" var="items">
            <tr>
                <td>${items.id}</td>
                <td>${items.name}</td>
                <td>${items.QQ}</td>
                <td>${items.major}</td>
                <td><date:date value="${items.startTime}"/></td>
                <td>${items.school}</td>
                <td>${items.student_Id}</td>
                <td>${items.daily_cone}</td>
                <td>${items.desire}</td>
                <td>${items.bre}</td>
                <td>${items.know_from}</td>
                <td><a href="${pageContext.request.contextPath}/rest/${items.id}">修改</a>
                    <a href="" onclick="sendBth(${items.id})">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>
